package com.kekmech.schedule.dto

data class GetGroupIdRequest(
    val groupNumber: String? = null
)

data class GetGroupIdResponse(
    val groupNumber: String,
    val groupId: String
)