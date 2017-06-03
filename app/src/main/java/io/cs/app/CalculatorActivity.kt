package io.cs.app

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.calculator.*

class CalculatorActivity : Activity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.calculator)

    listOf(
        button_0, button_1, button_2, button_3, button_4,
        button_5, button_6, button_7, button_8, button_9,
        button_plus
    ).forEach { btn -> btn.setOnClickListener { txt.append(btn.text) } }

    button_clear.setOnClickListener { txt.text = "" }

    button_equals.setOnClickListener {
      txt.text = txt.text.toString()
          .split('+')
          .toList()
          .map { it.toInt() }
          .reduce { a, b -> a + b }
          .toString()
    }
  }
}
