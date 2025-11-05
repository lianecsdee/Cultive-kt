package com.cultiveplus.cultiveplusapp.api

import com.cultiveplus.cultiveplusapp.model.Estufa
import retrofit2.Response
import retrofit2.http.GET

interface EstufaApiService {
    // APESAR DOS NOMES DOS MÉTODOS SEGUINDO O PADRÃO DA TABELA DADA POR:
    // https://laravel.com/docs/12.x/controllers#actions-handled-by-resource-controllers
    // TROCANDO APENAS O 'index' por 'all'
    // AS BOAS PRÁTICAS DO KOTLIN SUGEREM USAR NOMES DE MÉTODOS COM "VERBOS DESCRITIVOS"

    // 1. MÉTODO GET: Buscar a lista completa de usuários
    // URL: https://jsonplaceholder.typicode.com/users
    @GET("users")
    suspend fun getEstufas(): Response<List<Estufa>>

    // 2. MÉTODO GET por ID (com parâmetro de caminho)
    // URL: https://jsonplaceholder.typicode.com/users/{id}
//    @GET("users/{id}")
//    suspend fun getEstufa(@Path("id") userId: Int): Response<User>

    // 3. MÉTODO POST: Enviar um novo recurso (exemplo)
    // O corpo da requisição é o objeto User
//    @POST("users")
//    suspend fun createEstufa(@Body user: User): Response<User>

    // 4. MÉTODO DELETE: Excluir um recurso
    // URL: https://jsonplaceholder.typicode.com/users/{id}
//    @DELETE("users/{id}")
//    suspend fun deleteEstufa(@Path("id") userId: Int): Response<Unit> // Response<Unit> para resposta vazia
}