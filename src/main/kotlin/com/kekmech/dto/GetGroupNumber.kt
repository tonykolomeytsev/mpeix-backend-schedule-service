package com.kekmech.dto

data class GetGroupIdRequest(
    val groupNumber: String? = null
)

data class GetGroupIdResponse(
    val groupId: String
)