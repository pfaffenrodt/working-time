package de.pfaffenrodt.workingtime

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import com.arkivanov.decompose.defaultComponentContext
import de.pfaffenrodt.workingtime.data.SqliteDataComponent
import de.pfaffenrodt.workingtime.data.database.DriverFactory
import de.pfaffenrodt.workingtime.data.database.createDatabase

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val database = createDatabase(DriverFactory(applicationContext))
        val root = RootComponent(
            componentContext = defaultComponentContext(),
            data = SqliteDataComponent(database)
        )
        setContent {
            App(root)
        }
    }
}
