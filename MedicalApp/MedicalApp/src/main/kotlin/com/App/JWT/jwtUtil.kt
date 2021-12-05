package com.App.JWT


import com.App.Exception.JwtTokenMalformedException
import com.App.Exception.JwtTokenMissingException
import io.jsonwebtoken.*
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.util.*

@Component
class JwtUtil {
    @Value("\${jwt.secret}")
    private val jwtSecret: String? = null

    @Value("\${jwt.token.validity}")
    private val tokenValidity: Long = 0
    fun getClaims(token: String?): Claims? {
        try {
            return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).body
        } catch (e: Exception) {
            println(e.message + " => " + e)
        }
        return null
    }
    fun generateToken(id: String?): String {
        val claims = Jwts.claims().setSubject(id)
        val nowMillis = System.currentTimeMillis()
        val expMillis = nowMillis + tokenValidity

        val exp = Date(expMillis)
        return Jwts.builder().setClaims(claims).setIssuedAt(Date(nowMillis)).setExpiration(exp)
            .signWith(SignatureAlgorithm.HS512, jwtSecret).compact()
    }

    @Throws(JwtTokenMalformedException::class, JwtTokenMissingException::class)
    fun validateToken(token: String?) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token)
        } catch (ex: SignatureException) {
            throw JwtTokenMalformedException("Invalid JWT signature")
        } catch (ex: MalformedJwtException) {
            throw JwtTokenMalformedException("Invalid JWT token")
        } catch (ex: ExpiredJwtException) {
            throw JwtTokenMalformedException("Expired JWT token")
        } catch (ex: UnsupportedJwtException) {
            throw JwtTokenMalformedException("Unsupported JWT token")
        } catch (ex: IllegalArgumentException) {
            throw JwtTokenMissingException("JWT claims string is empty.")
        }
    }
}
