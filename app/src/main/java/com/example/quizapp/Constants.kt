package com.example.quizapp

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTONS : String = "total_question"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun QuestionList(): ArrayList<Question> {
        val questionlist = ArrayList<Question>()
        val que1 = Question(
            1,
            "Which one is Argentina Flag?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "India",
            "America",
            "China",
            1
        )
        questionlist.add(que1)

        val que2 = Question(
            2,
            "Which one is Australia Flag?",
            R.drawable.ic_flag_of_australia,
            "Australia",
            "India",
            "America",
            "China",
            1
        )
        questionlist.add(que2)

//        val que1 = Question(
//            1,
//            "Which one is Argentina Flag?",
//            R.drawable.ic_flag_of_argentina,
//            "Argentina",
//            "India",
//            "America",
//            "China",
//            1
//        )
//        questionlist.add(que1)
//
//        val que1 = Question(
//            1,
//            "Which one is Argentina Flag?",
//            R.drawable.ic_flag_of_argentina,
//            "Argentina",
//            "India",
//            "America",
//            "China",
//            1
//        )
//        questionlist.add(que1)
//
//        val que1 = Question(
//            1,
//            "Which one is Argentina Flag?",
//            R.drawable.ic_flag_of_argentina,
//            "Argentina",
//            "India",
//            "America",
//            "China",
//            1
//        )
//        questionlist.add(que1)
//
//        val que1 = Question(
//            1,
//            "Which one is Argentina Flag?",
//            R.drawable.ic_flag_of_argentina,
//            "Argentina",
//            "India",
//            "America",
//            "China",
//            1
//        )
//        questionlist.add(que1)
//
//        val que1 = Question(
//            1,
//            "Which one is Argentina Flag?",
//            R.drawable.ic_flag_of_argentina,
//            "Argentina",
//            "India",
//            "America",
//            "China",
//            1
//        )
//        questionlist.add(que1)
//
//        val que1 = Question(
//            1,
//            "Which one is Argentina Flag?",
//            R.drawable.ic_flag_of_argentina,
//            "Argentina",
//            "India",
//            "America",
//            "China",
//            1
//        )
//        questionlist.add(que1)
//
//        val que1 = Question(
//            1,
//            "Which one is Argentina Flag?",
//            R.drawable.ic_flag_of_argentina,
//            "Argentina",
//            "India",
//            "America",
//            "China",
//            1
//        )
//        questionlist.add(que1)
//
//        val que1 = Question(
//            1,
//            "Which one is Argentina Flag?",
//            R.drawable.ic_flag_of_argentina,
//            "Argentina",
//            "India",
//            "America",
//            "China",
//            1
//        )
//        questionlist.add(que1)
        return questionlist
    }
}