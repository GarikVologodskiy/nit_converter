/*
Загрузите, распакуйте и импортируйте проект Android-приложения по ссылке.

Создайте приложение для конвертации величин из дюймов в километры и наоборот.

Интерфейс:

EditText (id editText) - поле ввода/вывода значения в дюймах.
EditText (id editText2) поле для ввода/вывода значения в километрах .
TextView (id status) - статус операции
Принцип работы:

Число, введенное в первое поле ввода конвертируется и выводится во втором поле и наоборот(editText - дюймы, editText2 - километры).
Конвертация происходит путем умножения/деления числа на константу, связывающую километры и дюймы:

1 км ~ 39370 inc

Точность значений соответствует типу Float. Если введенные данные некорректны, необходимо вывести "error" в элементе с id status.
Если операция корректна, status должен быть пуст. Обратите внимание на то, что пустая строка является ошибкой!

Для того, чтобы выполнить проверку запустите espresso-тесты.
Если вы выполнили задание верно, то все тесты пройдут успешно.
После того, как это произойдет найдете в Logcat строку c tag == CHECKER.
Скопируйте всю строку целиком (включая метку времени) в поле ниже.

 editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                       }
            }

            setOnKeyListener {v, keyCode, event ->
            try {...}
            catch ()
            } return@setOnKeyListener false
*/

package com.example.company.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val inchesInKilometer = 39370

/*        editText.setOnKeyListener { v, keyCode, event ->
            try {
                editText2.setText((editText.text.toString().toFloat() / inchesInKilometer).toString()).let { status.text = "" }
                *//*if (editText.getText().toString().equals("")) {
                    editText2.getText().clear()
                }*//*
            } catch (e: NumberFormatException) {
                status.text = "error"
            }; return@setOnKeyListener false
        }
        editText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                editText.setText("")
                status.text = "error"
            }
            else if (editText.text.isEmpty()) {
                status.text = "error"
            }
        }
    }*/
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                if (editText.isFocused) {
                    transformation(true)
                }
            }
        })

/*        editText2.setOnKeyListener { v, keyCode, event ->
            try {
                editText.setText((editText2.text.toString().toFloat() * inchesInKilometer).toString()).let { status.text = "" }
                *//*if (editText2.getText().toString().equals("")) {
                    editText.getText().clear()
                }*//*
            } catch (e: NumberFormatException) {
                status.text = "error"
            }; return@setOnKeyListener false
        }
        editText2.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                editText2.setText("")
                status.text = "error"
            }
            else if (editText2.text.isEmpty()) {
                status.text = "error"
            }
        }*/
        editText2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (editText2.isFocused) {
                    transformation(false)
                }
            }
        })
    }

    private fun transformation(changedFlag: Boolean) {
        val inchesInKilometer = 39370

        if (changedFlag) {

            val inc: Float? = editText.text.toString().toFloatOrNull()

            if (inc != null) {
                status.text = ""
                val kilo_result: Float = inc / inchesInKilometer
                editText2.setText(kilo_result.toString())
            } else {
                status.text = "error"
            }
        } else {
            val kilo: Float? = editText2.text.toString().toFloatOrNull()

            if (kilo != null) {
                status.text = ""
                val inc_result: Float = kilo * inchesInKilometer
                editText.setText(inc_result.toString())
            } else {
                status.text = "error"
            }
        }

        editText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus) {
                editText.setText("")
                status.text = "error"
            }

            editText2.setOnFocusChangeListener { v, hasFocus ->
                if (hasFocus) {
                    editText2.setText("")
                    status.text = "error"
                }
            }
        }
    }
}