package com.example.compose_basics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_basics.ui.theme.Compose_BasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }
        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Compose_BasicsTheme {

        /** ---------- A surface container using the 'background' color from the theme ---------- */
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            content()
        }
    }
}

@Composable
fun MyScreenContent(names:List<String> = listOf("Android", "There")) {
    var counterState by remember {
        mutableStateOf(0)
    }
    Column {
        for (name : String in names) {
            Greeting(name = name)
//            Greeting(name = "There")
        }
//            Greeting(name = "Android")
        Counter(
            count = counterState,
            updateCount = { newCount : Int ->
                counterState = newCount
            }
        )
        if (counterState > 5){
            Text(text = "I love the count")
        }
    }
}

@Composable
fun Counter(count: Int, updateCount:(Int) -> Unit){

    /**------------------------ button Added ------------------------ */
            Button(onClick = {updateCount(count + 1)}) {
        Text(text = "I've been clicked $count times")

    }
}

@Composable
fun Greeting(name: String) {


    /** ------------------------ changing background colour in text ------------------------ */
    Surface(color = Color.Unspecified) {

        /** ---------- spacing - 16 dp in colour background area ---------- */
        Text(
            text = "Hello $name!",
            modifier = Modifier.padding(16.dp)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent()
    }
}