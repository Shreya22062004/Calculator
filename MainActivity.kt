package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import kotlin.ArithmeticException

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonAc.setOnClickListener {
            binding.inputText.text = " "
            binding.outputText.text = " "
        }

        binding.button0.setOnClickListener {
            binding.inputText.append("0")
        }

        binding.button1.setOnClickListener {
            binding.inputText.append("1")
        }

        binding.button2.setOnClickListener {
            binding.inputText.append("2")
        }

        binding.button3.setOnClickListener {
            binding.inputText.append("3")
        }

        binding.button4.setOnClickListener {
            binding.inputText.append("4")
        }

        binding.button5.setOnClickListener {
            binding.inputText.append("5")
        }

        binding.button6.setOnClickListener {
            binding.inputText.append("6")
        }

        binding.button7.setOnClickListener {
            binding.inputText.append("7")
        }

        binding.button8.setOnClickListener {
            binding.inputText.append("8")
        }

        binding.button9.setOnClickListener {
            binding.inputText.append("9")
        }

        binding.buttonDot.setOnClickListener {
            binding.inputText.append(" . ")
        }

        binding.buttonAdd.setOnClickListener {
            binding.inputText.append(" + ")
        }

        binding.buttonSubtract.setOnClickListener {
            binding.inputText.append(" - ")
        }

        binding.buttonDivide.setOnClickListener {
            binding.inputText.append(" / ")
        }

        binding.buttonMultiply.setOnClickListener {
            binding.inputText.append(" * ")
        }

        binding.buttonOpenBracket.setOnClickListener {
            binding.inputText.append(" ( ")
        }

        binding.buttonCloseBracket.setOnClickListener {
            binding.inputText.append(" ) ")
        }

        binding.buttonEquals.setOnClickListener {
            try {
                val expression = ExpressionBuilder(binding.inputText.text.toString()).build()
                val result = expression.evaluate()
                val longresult = result.toLong()

                if (result == longresult.toDouble()) {
                    binding.outputText.text = longresult.toString()
                } else {
                    binding.outputText.text = result.toString()
                }
            }
                catch( e: ArithmeticException) {
                    binding.outputText.text = "Error: infinite"
                }
                catch (e: Exception) {
                    binding.outputText.text = "Error"
                }

            binding.buttonC.setOnClickListener {
                val currentText = binding.inputText.text.toString()
                if (currentText.isNotEmpty()) {
                    binding.inputText.text = currentText.dropLast(1)
                }
            }

            ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v , insets ->
                val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
                insets
            }
        }
    }
}