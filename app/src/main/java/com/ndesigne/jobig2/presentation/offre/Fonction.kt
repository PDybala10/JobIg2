package com.ndesigne.jobig2.presentation.offre


object Fonction {
    fun cleanString(chaine: String): String {
        var s = ""
        var j = 0
        val arr = chaine.toCharArray()
        for (i in arr.indices) {
            if (arr[i] == '<') {
                j = 1
            }
            if (j == 0) {
                s = s + arr[i]
            }
            if (arr[i] == '>') {
                j = 0
            }
        }
        return s
    }

    fun cleanString2(chaine: String): String {
        var s = ""
        var j = 0
        val arr = chaine.toCharArray()
        for (i in arr.indices) {
            if (arr[i] == '(') {
                j = 1
            }
            if (j == 0) {
                s = s + arr[i]
            }
            if (arr[i] == ')') {
                j = 0
            }
        }
        return s
    }
}
