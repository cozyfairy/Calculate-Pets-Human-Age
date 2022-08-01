package com.cozyfairyllc.calculateyourpetshumanage

import java.util.concurrent.TimeUnit

class HumanAge {
    companion object {
        fun convertAge(species: Int, dob : Long): Int = calculateHumanAge(species, dob)
        private fun calculateYears(dob: Long): Int {
            val currentTime = System.currentTimeMillis()
            val elapsedTime = currentTime - dob
            return (TimeUnit.MILLISECONDS.toDays(elapsedTime) / 365).toInt()
        }
        private fun calculateHumanAge(species: Int, dob: Long): Int = when (species) {
            0 -> 3 * calculateYears(dob)
            1 -> calculateCatsHumanAge(dob)
            2 -> calculateDogsAge(dob)
            else -> 0
        }
        private fun calculateDogsAge(dob: Long): Int {
            val years = calculateYears(dob)
            var humanAge = 0
            if (years >= 1) humanAge += 15
            if (years >= 2) humanAge += 9
            if (years >= 3) humanAge += (humanAge - 2) * 5
            return humanAge
        }
        private fun calculateMonths(dob: Long): Int {
            val currentTime = System.currentTimeMillis()
            val elapsedTime = currentTime - dob
            return (TimeUnit.MILLISECONDS.toDays(elapsedTime) / 30).toInt()
        }
        private fun calculateCatsHumanAge(dob: Long): Int {
            val years = calculateYears(dob)
            val months = calculateMonths(dob)
            val humanAge: Int = if (years >= 11) {
                60 + ((years - 11) * 4)
            } else if (years >= 3) {
                28 + ((years - 3) * 4)
            } else if (years >= 2) {
                24
            } else if (months >= 18) {
                21
            } else if (years >= 1) {
                15
            } else if (months >= 5) {
                10
            } else if (months >= 3) {
                4
            } else {
                1
            }
            return humanAge
        }

    }
}