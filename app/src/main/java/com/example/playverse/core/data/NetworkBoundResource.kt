package com.example.playverse.core.data

import com.example.playverse.ui.utils.Output
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

abstract class NetworkBoundResource<ResultType, RequestType>{

    private var output: Flow<Output<ResultType>> = flow {
        emit(Output.Loading())
        val dbSource = loadFromDB().first()
        if (shouldFetch(dbSource)){
            when(val result = createCall().first()){
                is Output.Success -> {
                    saveCallResult(result.data!!)
                    emit(Output.Success(loadFromDB().first()))
                }
                is Output.Error -> {
                    onFetchFailed()
                    emit(Output.Error(result.message.toString()))
                }
                else -> {
                    onFetchFailed()
                    emit(Output.Error(result.message.toString()))
                }
            }
        } else {
            emitAll(loadFromDB().map { Output.Success(it) })
        }
    }

    protected open fun onFetchFailed() {}

    protected abstract fun loadFromDB(): Flow<ResultType>

    protected abstract fun shouldFetch(data: ResultType?): Boolean

    protected abstract suspend fun createCall(): Flow<Output<RequestType>>

    protected abstract suspend fun saveCallResult(data: RequestType)

    fun asFlow(): Flow<Output<ResultType>> = output
}