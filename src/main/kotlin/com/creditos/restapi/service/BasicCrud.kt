package com.creditos.restapi.service

interface BasicCrud<T, ID> {

    fun list(): List<T>
    fun get(id: ID): T
    fun save(t: T): T
    fun remove(id: ID)
}