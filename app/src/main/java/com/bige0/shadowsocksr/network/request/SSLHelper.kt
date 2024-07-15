package com.bige0.shadowsocksr.network.request

import android.annotation.*
import java.security.cert.*
import javax.net.ssl.*

/**
 * @author Army
 * @version V_1.0.0
 * @date 2024/7/16
 * @description
 */
object SSLHelper
{

	// 获取一个信任所有证书的SSL Socket Factory
	fun getTrustAllSSLSocketFactory(): SSLSocketFactory
	{
		val sslContext = SSLContext.getInstance("TLS")
		sslContext.init(
			null, arrayOf<TrustManager>(getTrustAllManager()), null
		)
		return sslContext.socketFactory
	}

	// 获取一个信任所有证书的TrustManager
	@SuppressLint("CustomX509TrustManager")
	fun getTrustAllManager(): X509TrustManager
	{
		return object : X509TrustManager
		{
			@SuppressLint("TrustAllX509TrustManager")
			override fun checkClientTrusted(chain: Array<X509Certificate>, authType: String)
			{
			}

			@SuppressLint("TrustAllX509TrustManager")
			override fun checkServerTrusted(chain: Array<X509Certificate>, authType: String)
			{
			}

			override fun getAcceptedIssuers(): Array<X509Certificate>
			{
				return emptyArray()
			}
		}
	}
}




