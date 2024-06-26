package com.example.wallet.data.repository


import com.example.wallet.data.local.dao.UserDao
import com.example.wallet.data.network.api.WalletServiceAPI
import com.example.wallet.data.response.UserCreatedResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class RepositoryImp (private val userApi: WalletServiceAPI,
                     private val userDao: UserDao
    ):UserRepository {

    override suspend fun crearUser(user: UserCreatedResponse): Response<UserCreatedResponse> {
        return withContext(Dispatchers.IO) {
            userApi.registerUser(user)
        }
    }

    /*override suspend fun loginUser(user: LoginRequest): Response<LoginResponse> {
        return withContext(Dispatchers.IO) {
            userApi.userLogin(user)
        }
    }

    override suspend fun insertarUsuarioBaseDatos(user: User) {
        return withContext(Dispatchers.IO) {
            userDao.insertUser(user)
        }
    }*/
}