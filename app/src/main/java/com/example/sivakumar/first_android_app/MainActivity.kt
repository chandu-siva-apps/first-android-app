package com.example.sivakumar.first_android_app

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent.KEYCODE_DPAD_DOWN
import android.view.KeyEvent.KEYCODE_SLASH
import android.view.KeyEvent.KEYCODE_C
import android.view.KeyEvent.KEYCODE_PERIOD
import android.view.KeyEvent.KEYCODE_MINUS
import android.view.KeyEvent.KEYCODE_EQUALS
import android.view.KeyEvent.KEYCODE_9
import android.view.KeyEvent.KEYCODE_8
import android.view.KeyEvent.KEYCODE_7
import android.view.KeyEvent.KEYCODE_6
import android.view.KeyEvent.KEYCODE_5
import android.view.KeyEvent.KEYCODE_4
import android.view.KeyEvent.KEYCODE_3
import android.view.KeyEvent.KEYCODE_2
import android.view.KeyEvent.KEYCODE_1
import android.view.KeyEvent.KEYCODE_0
import android.widget.EditText
import android.util.DisplayMetrics
import android.view.*
import android.widget.Button


class MainActivity : AppCompatActivity() {

    private val SDK_VERSION = "1"
    private val MENUITEM_CLOSE = 300
    private val SWIPE_MIN_DISTANCE = 120
    private val SWIPE_MAX_OFF_PATH = 250
    private val SWIPE_THRESHOLD_VELOCITY = 200
    private val gestureDetector: GestureDetector? = null

    /*
	 * Edit Text and Button object initialization for simple calculator design.
	 */
    private var txtCalc: EditText? = null
    private var btnZero: Button? = null
    private var btnOne: Button? = null
    private var btnTwo: Button? = null
    private var btnThree: Button? = null
    private var btnFour: Button? = null
    private var btnFive: Button? = null
    private var btnSix: Button? = null
    private var btnSeven: Button? = null
    private var btnEight: Button? = null
    private var btnNine: Button? = null
    private var btnPlus: Button? = null
    private var btnMinus: Button? = null
    private var btnMultiply: Button? = null
    private var btnDivide: Button? = null
    private var btnEquals: Button? = null
    private var btnC: Button? = null
    private var btnDecimal: Button? = null
    private var btnMC: Button? = null
    private var btnMR: Button? = null
    private var btnMM: Button? = null
    private var btnMP: Button? = null
    private var btnBS: Button? = null
    private var btnPerc: Button? = null
    private var btnSqrRoot: Button? = null
    private var btnPM: Button? = null
    private var expSQ: Button? = null
    private var expEX: Button? = null
    private var nbtn1: Button? = null
    private var nbtn2: Button? = null
    private var nbtn3: Button? = null
    private var nbtn4: Button? = null
    private var nbtn5: Button? = null
    private var nbtn6: Button? = null
    private var nbtn7: Button? = null

    private var num = 0.0
    private var memNum = 0.0
    private var operator = 1
    // 0 = nothing, 1 = plus, 2 = minus, 3 =
    // multiply, 4 = divide
    private var readyToClear = false
    private var hasChanged = false

    /** Called when the activity is first created.  */
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_Black)
        setContentView(R.layout.activity_main)

        this.title = " "

        initControls()
        initScreenLayout()
        reset()

    }

    private fun initScreenLayout() {

        /*
		 * The following three command lines you can use depending upon the
		 * emulator device you are using.
		 */

        // 320 x 480 (Tall Display - HVGA-P) [default]
        // 320 x 240 (Short Display - QVGA-L)
        // 240 x 320 (Short Display - QVGA-P)

        val dm = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)

        // this.showAlert(dm.widthPixels +" "+ dm.heightPixels, dm.widthPixels
        // +" "+ dm.heightPixels, dm.widthPixels +" "+ dm.heightPixels, false);

        val height = dm.heightPixels
        val width = dm.widthPixels

        if (height < 400 || width < 300) {
            txtCalc!!.textSize = 20f
        }

        if (width < 300) {
            btnMC!!.setTextSize(18F)
            btnMR!!.setTextSize(18F)
            btnMP!!.setTextSize(18F)
            btnMM!!.setTextSize(18F)
            btnBS!!.setTextSize(18F)
            btnDivide!!.setTextSize(18F)
            btnPlus!!.setTextSize(18F)
            btnMinus!!.setTextSize(18F)
            btnMultiply!!.setTextSize(18F)
            btnEquals!!.setTextSize(18F)
            btnPM!!.setTextSize(18F)
            btnPerc!!.setTextSize(18F)
            btnC!!.setTextSize(18F)
            btnSqrRoot!!.setTextSize(18F)
            btnNine!!.setTextSize(18F)
            btnEight!!.setTextSize(18F)
            btnSeven!!.setTextSize(18F)
            btnSix!!.setTextSize(18F)
            btnFive!!.setTextSize(18F)
            btnFour!!.setTextSize(18F)
            btnThree!!.setTextSize(18F)
            btnTwo!!.setTextSize(18F)
            btnOne!!.setTextSize(18F)
            btnZero!!.setTextSize(18F)
            btnDecimal!!.setTextSize(18F)
            expSQ!!.setTextSize(18F)
            expEX!!.setTextSize(18F)
            nbtn1!!.setTextSize(18F)
            nbtn2!!.setTextSize(18F)
            nbtn3!!.setTextSize(18F)
            nbtn4!!.setTextSize(18F)
            nbtn5!!.setTextSize(18F)
            nbtn6!!.setTextSize(18F)
            nbtn7!!.setTextSize(18F)
        }

        txtCalc!!.setTextColor(Color.WHITE)
        txtCalc!!.setBackgroundColor(Color.BLACK)
        txtCalc!!.keyListener = null

        btnZero!!.setTextColor(Color.WHITE)
        btnOne!!.setTextColor(Color.WHITE)
        btnTwo!!.setTextColor(Color.WHITE)
        btnThree!!.setTextColor(Color.WHITE)
        btnFour!!.setTextColor(Color.WHITE)
        btnFive!!.setTextColor(Color.WHITE)
        btnSix!!.setTextColor(Color.WHITE)
        btnSeven!!.setTextColor(Color.WHITE)
        btnEight!!.setTextColor(Color.WHITE)
        btnNine!!.setTextColor(Color.WHITE)
        btnPM!!.setTextColor(Color.WHITE)
        btnDecimal!!.setTextColor(Color.WHITE)

        btnMP!!.setTextColor(Color.WHITE)
        btnMM!!.setTextColor(Color.WHITE)
        btnMR!!.setTextColor(Color.WHITE)
        btnMC!!.setTextColor(Color.WHITE)
        btnBS!!.setTextColor(Color.WHITE)
        btnC!!.setTextColor(Color.WHITE)
        btnPerc!!.setTextColor(Color.WHITE)
        btnSqrRoot!!.setTextColor(Color.WHITE)
        btnDivide!!.setTextColor(Color.WHITE)
        btnPlus!!.setTextColor(Color.WHITE)
        btnMinus!!.setTextColor(Color.WHITE)
        btnMultiply!!.setTextColor(Color.WHITE)
        btnEquals!!.setTextColor(Color.WHITE)
        expSQ!!.setTextColor(Color.WHITE)
        expEX!!.setTextColor(Color.WHITE)

        nbtn1!!.setTextColor(Color.WHITE)
        nbtn2!!.setTextColor(Color.WHITE)
        nbtn3!!.setTextColor(Color.WHITE)
        nbtn4!!.setTextColor(Color.WHITE)
        nbtn5!!.setTextColor(Color.WHITE)
        nbtn6!!.setTextColor(Color.WHITE)
        nbtn7!!.setTextColor(Color.WHITE)

    }

    private fun initControls() {
        txtCalc = findViewById(R.id.txtCalc) as EditText
        btnZero = findViewById(R.id.btnZero) as Button
        btnOne = findViewById(R.id.btnOne) as Button
        btnTwo = findViewById(R.id.btnTwo) as Button
        btnThree = findViewById(R.id.btnThree) as Button
        btnFour = findViewById(R.id.btnFour) as Button
        btnFive = findViewById(R.id.btnFive) as Button
        btnSix = findViewById(R.id.btnSix) as Button
        btnSeven = findViewById(R.id.btnSeven) as Button
        btnEight = findViewById(R.id.btnEight) as Button
        btnNine = findViewById(R.id.btnNine) as Button
        btnPlus = findViewById(R.id.btnPlus) as Button
        btnMinus = findViewById(R.id.btnMinus) as Button
        btnMultiply = findViewById(R.id.btnMultiply) as Button
        btnDivide = findViewById(R.id.btnDivide) as Button
        btnEquals = findViewById(R.id.btnEquals) as Button
        btnC = findViewById(R.id.btnC) as Button
        btnDecimal = findViewById(R.id.btnDecimal) as Button
        btnMC = findViewById(R.id.btnMC) as Button
        btnMR = findViewById(R.id.btnMR) as Button
        btnMM = findViewById(R.id.btnMM) as Button
        btnMP = findViewById(R.id.btnMP) as Button
        btnBS = findViewById(R.id.btnBS) as Button
        btnPerc = findViewById(R.id.btnPerc) as Button
        btnSqrRoot = findViewById(R.id.btnSqrRoot) as Button
        btnPM = findViewById(R.id.btnPM) as Button
        expSQ = findViewById(R.id.expSQ) as Button
        expEX = findViewById(R.id.expEX) as Button
        nbtn1 = findViewById(R.id.nbtn1) as Button
        nbtn2 = findViewById(R.id.nbtn2) as Button
        nbtn3 = findViewById(R.id.nbtn3) as Button
        nbtn4 = findViewById(R.id.nbtn4) as Button
        nbtn5 = findViewById(R.id.nbtn5) as Button
        nbtn6 = findViewById(R.id.nbtn6) as Button
        nbtn7 = findViewById(R.id.nbtn7) as Button

        nbtn1!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(12)

            }

        }

        nbtn2!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(7)

            }

        }

        nbtn3!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(8)

            }

        }

        nbtn4!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(9)

            }

        }

        nbtn5!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(10)

            }

        }

        nbtn6!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(11)

            }

        }

        nbtn7!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(13)

            }

        }

        btnZero!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(0)

            }

        }
        expSQ!!.setOnClickListener {
            fun onClick(v: View) {
                setValue(java.lang.Double.toString(Math.cbrt(java.lang.Double.parseDouble(txtCalc!!
                        .text.toString()))))
            }

        }
        expEX!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(6)
            }

        }
        btnOne!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(1)
            }
        }
        btnTwo!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(2)
            }
        }
        btnThree!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(3)
            }
        }
        btnFour!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(4)
            }
        }
        btnFive!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(5)
            }
        }
        btnSix!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(6)
            }
        }
        btnSeven!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(7)
            }
        }
        btnEight!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(8)
            }
        }
        btnNine!!.setOnClickListener {
            fun onClick(v: View) {
                handleNumber(9)
            }
        }
        btnPlus!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(1)
            }
        }
        btnMinus!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(2)
            }
        }
        btnMultiply!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(3)
            }
        }
        btnDivide!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(4)
            }
        }
        btnEquals!!.setOnClickListener {
            fun onClick(v: View) {
                handleEquals(0)
            }
        }
        btnC!!.setOnClickListener {
            fun onClick(v: View) {
                reset()
            }
        }
        btnDecimal!!.setOnClickListener {
            fun onClick(v: View) {
                handleDecimal()
            }
        }
        btnPM!!.setOnClickListener {
            fun onClick(v: View) {
                handlePlusMinus()
            }
        }
        btnMC!!.setOnClickListener {
            fun onClick(v: View) {
                memNum = 0.0
            }
        }
        btnMR!!.setOnClickListener {
            fun onClick(v: View) {
                setValue(java.lang.Double.toString(memNum))
            }
        }
        btnMM!!.setOnClickListener {
            fun onClick(v: View) {
                memNum = memNum - java.lang.Double.parseDouble(txtCalc!!.text.toString())
                operator = 0
            }
        }
        btnMP!!.setOnClickListener {
            fun onClick(v: View) {
                memNum = memNum + java.lang.Double.parseDouble(txtCalc!!.text.toString())
                operator = 0
            }
        }
        btnBS!!.setOnClickListener {
            fun onClick(v: View) {
                handleBackspace()
            }
        }
        btnSqrRoot!!.setOnClickListener {
            fun onClick(v: View) {
                setValue(java.lang.Double.toString(Math.sqrt(java.lang.Double.parseDouble(txtCalc!!
                        .text.toString()))))
            }
        }
        btnPerc!!.setOnClickListener {
            fun onClick(v: View) {
                setValue(java.lang.Double.toString(num * (0.01 * java.lang.Double.parseDouble(txtCalc!!.text
                        .toString()))))
            }
        }

        txtCalc!!.setOnKeyListener(View.OnKeyListener { v, i, e ->
            if (e.action == KeyEvent.ACTION_DOWN) {
                val keyCode = e.keyCode

                // txtCalc.append("["+Integer.toString(keyCode)+"]");

                when (keyCode) {
                    KeyEvent.KEYCODE_0 -> handleNumber(0)

                    KeyEvent.KEYCODE_1 -> handleNumber(1)

                    KeyEvent.KEYCODE_2 -> handleNumber(2)

                    KeyEvent.KEYCODE_3 -> handleNumber(3)

                    KeyEvent.KEYCODE_4 -> handleNumber(4)

                    KeyEvent.KEYCODE_5 -> handleNumber(5)

                    KeyEvent.KEYCODE_6 -> handleNumber(6)

                    KeyEvent.KEYCODE_7 -> handleNumber(7)

                    KeyEvent.KEYCODE_8 -> handleNumber(8)

                    KeyEvent.KEYCODE_9 -> handleNumber(9)

                    43 -> handleEquals(1)

                    KeyEvent.KEYCODE_EQUALS -> handleEquals(0)

                    KeyEvent.KEYCODE_MINUS -> handleEquals(2)

                    KeyEvent.KEYCODE_PERIOD -> handleDecimal()

                    KeyEvent.KEYCODE_C -> reset()

                    KeyEvent.KEYCODE_SLASH -> handleEquals(4)

                    KeyEvent.KEYCODE_DPAD_DOWN -> return@OnKeyListener false
                }
            }

            true
        })
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menu.add(0, 1, MENUITEM_CLOSE, "Close")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            MENUITEM_CLOSE -> finish()
        }

        return super.onOptionsItemSelected(item)
    }

    private fun handleEquals(newOperator: Int) {
        if (hasChanged) {
            when (operator) {
                1 -> num = num + java.lang.Double.parseDouble(txtCalc!!.text.toString())
                2 -> num = num - java.lang.Double.parseDouble(txtCalc!!.text.toString())
                3 -> num = num * java.lang.Double.parseDouble(txtCalc!!.text.toString())
                4 -> num = num / java.lang.Double.parseDouble(txtCalc!!.text.toString())
                5 -> num = Math.pow(num, 2.0)
                6 -> num = Math.pow(num,
                        java.lang.Double.parseDouble(txtCalc!!.text.toString()))
                7 -> num = num + Math.sin(java.lang.Double.parseDouble(txtCalc!!.text
                        .toString()))
                8 -> num = num + Math.cos(java.lang.Double.parseDouble(txtCalc!!.text
                        .toString()))
                9 -> num = num + Math.tan(java.lang.Double.parseDouble(txtCalc!!.text
                        .toString()))
                10 -> num = Math
                        .log(java.lang.Double.parseDouble(txtCalc!!.text.toString()))
                11 -> {
                    val loge = Math.log(java.lang.Double.parseDouble(txtCalc!!.text
                            .toString()))
                    num = Math.exp(loge)
                }
                12 -> num = Math.PI
                13 -> num = Math.E
            }

            val txt = java.lang.Double.toString(num)
            txtCalc!!.setText(txt)
            txtCalc!!.setSelection(txt.length)

            readyToClear = true
            hasChanged = false
        }

        operator = newOperator
    }

    private fun handleNumber(num: Int) {
        if (operator == 0)
            reset()

        var txt = txtCalc!!.text.toString()
        if (readyToClear) {
            txt = ""
            readyToClear = false
        } else if (txt == "0")
            txt = ""

        txt = txt + Integer.toString(num)

        txtCalc!!.setText(txt)
        txtCalc!!.keyListener = null
        txtCalc!!.setSelection(txt.length)

        hasChanged = true
    }

    private fun setValue(value: String) {
        if (operator == 0)
            reset()

        if (readyToClear) {
            readyToClear = false
        }

        txtCalc!!.setText(value)
        txtCalc!!.setSelection(value.length)

        hasChanged = true
    }

    private fun handleDecimal() {
        if (operator == 0)
            reset()

        if (readyToClear) {
            txtCalc!!.setText("0.")
            txtCalc!!.setSelection(2)
            readyToClear = false
            hasChanged = true
        } else {
            val txt = txtCalc!!.text.toString()

            if (!txt.contains(".")) {
                txtCalc!!.append(".")
                hasChanged = true
            }
        }
    }

    private fun handleBackspace() {
        if (!readyToClear) {
            var txt = txtCalc!!.text.toString()
            if (txt.length > 0) {
                txt = txt.substring(0, txt.length - 1)
                if (txt == "")
                    txt = "0"

                txtCalc!!.setText(txt)
                txtCalc!!.setSelection(txt.length)
            }
        }
    }

    private fun handlePlusMinus() {
        if (!readyToClear) {
            var txt = txtCalc!!.text.toString()
            if (txt != "0") {
                if (txt[0] == '-')
                    txt = txt.substring(1, txt.length)
                else
                    txt = "-" + txt

                txtCalc!!.setText(txt)
                txtCalc!!.setSelection(txt.length)
            }
        }
    }

    private fun reset() {
        num = 0.0
        txtCalc!!.setText("0")
        txtCalc!!.setSelection(1)
        operator = 1
    }

}
