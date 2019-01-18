package com.robsonmonteiro.koindependencyinjection.data

class DataRepositoryFactory constructor(
    private val localDataSource: DataRepository,
    private val remoteDataSource: DataRepository
) {

    fun retriveRemoteSource(): DataRepository = remoteDataSource

    fun retriveLocalSource(): DataRepository = localDataSource

}