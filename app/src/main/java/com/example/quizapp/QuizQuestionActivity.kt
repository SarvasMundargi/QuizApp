package com.example.quizapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuizQuestionBinding

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition : Int =1
    private var mQuestionList : ArrayList<Question>? = null
    private var mSelectedOptionPosition : Int =0
    private var mCorrectAnswers : Int =0
    private var mUsername : String? = null
    private lateinit var binding : ActivityQuizQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mUsername=intent.getStringExtra(Constants.USER_NAME)
        mQuestionList = Constants.QuestionList()
        setQuestion()

        binding.tvOptionone.setOnClickListener(this)
        binding.tvOptiontwo.setOnClickListener(this)
        binding.tvOptionthree.setOnClickListener(this)
        binding.tvOptionfour.setOnClickListener(this)
        binding.btnSubmit.setOnClickListener(this)
    }

    private fun setQuestion(){



        val question = mQuestionList!![mCurrentPosition-1]
        defaultOptionView()
        if(mCurrentPosition==mQuestionList!!.size){
            binding.btnSubmit.text="FINISH"
        }else{
            binding.btnSubmit.text="SUBMIT"
        }

        binding.progressBar.progress=mCurrentPosition
        binding.tvProgress.text="$mCurrentPosition" + "/" + binding.progressBar.max

        binding.tvQuestion.text=question!!.question
        binding.ivFlag.setImageResource(question.image)
        binding.tvOptionone.text=question.optionone
        binding.tvOptiontwo.text=question.optiontwo
        binding.tvOptionthree.text=question.optionthree
        binding.tvOptionfour.text=question.optionfour
    }
    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        options.add(0,binding.tvOptionone)
        options.add(1,binding.tvOptiontwo)
        options.add(2,binding.tvOptionthree)
        options.add(3,binding.tvOptionfour)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.textview_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.tv_optionone->{
                selectedOptionView(binding.tvOptionone,1)
            }
            R.id.tv_optiontwo->{
                selectedOptionView(binding.tvOptiontwo,2)
            }
            R.id.tv_optionthree->{
                selectedOptionView(binding.tvOptionthree,3)
            }
            R.id.tv_optionfour->{
                selectedOptionView(binding.tvOptionfour,4)
            }
            R.id.btn_submit->{
                if(mSelectedOptionPosition==0){
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionList!!.size->{
                            setQuestion()
                        }else->{
                        val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME,mUsername)
                        intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTONS, mQuestionList!!.size)
                        startActivity(intent)
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border_bg)

                    if(mCurrentPosition==mQuestionList!!.size){
                        binding.btnSubmit.text="FINISH"
                    }
                    else{
                        binding.btnSubmit.text="GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition=0
                }


            }

        }
    }

    private fun answerView(answer:Int , drawableView : Int){
        when(answer){
            1->{
                binding.tvOptionone.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                binding.tvOptiontwo.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                binding.tvOptionthree.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                binding.tvOptionfour.background=ContextCompat.getDrawable(this,drawableView)
            }
        }
    }

    private fun selectedOptionView(tv : TextView,selectedOptionNumber: Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNumber
        tv.setTextColor(Color.parseColor("#22333b"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border)
    }

}