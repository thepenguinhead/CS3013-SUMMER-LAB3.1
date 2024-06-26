package com.example.a3_01_group5
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

interface AnswersListener {
    fun onSelected(questionId: Int)
}

class QuestionsFragment : Fragment(), View.OnClickListener {

    private lateinit var answersListener: AnswersListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is AnswersListener) {
            answersListener = context
        } else {
            throw RuntimeException("Must implement AnswersListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_question, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val planets = listOf<View>(
            view.findViewById(R.id.most_moons),
            view.findViewById(R.id.largest_planet),
            view.findViewById(R.id.side_spinning)
        )

        planets.forEach {
            it.setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {

        v?.let { question ->
            answersListener.onSelected(question.id)
        }
    }
}