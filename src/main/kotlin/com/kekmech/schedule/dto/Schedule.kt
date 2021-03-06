package com.kekmech.schedule.dto

import java.io.Serializable
import java.time.LocalDate
import java.time.LocalTime

data class Schedule(
    @Deprecated("Used only name and id since version 1.4.0", replaceWith = ReplaceWith("name"))
    val groupNumber: String? = null,
    @Deprecated("Used only name and id since version 1.4.0", replaceWith = ReplaceWith("id"))
    val groupId: String? = null,

    val name: String? = null,
    val id: String? = null,
    val type: ScheduleType? = null,
    val weeks: List<Week> = emptyList()
) : Serializable

data class Week(
    val weekOfYear: Int = 0,
    val weekOfSemester: Int = 0,
    val firstDayOfWeek: LocalDate = LocalDate.now(),
    val days: List<Day> = emptyList()
) : Serializable

data class Day(
    val dayOfWeek: Int = 0,
    val date: LocalDate = LocalDate.now(),
    val classes: List<Classes> = emptyList()
) : Serializable

data class Classes(
    val name: String = "",
    val type: ClassesType = ClassesType.UNDEFINED,
    val place: String = "",
    val groups: String = "",
    val person: String = "",
    val time: Time = Time(),
    val number: Int,
    val rawType: String = ""
) : Serializable

data class Time(
    val start: LocalTime = LocalTime.now(),
    val end: LocalTime = LocalTime.now()
) : Serializable

enum class ClassesType : Serializable { UNDEFINED, LECTURE, PRACTICE, LAB, COURSE, CONSULTATION, EXAM }

enum class ScheduleType(val raw: String) : Serializable { GROUP("group"), PERSON("person") }