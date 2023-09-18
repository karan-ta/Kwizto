import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyShortcut
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.kwizto.common.KwiztoFileTree
import java.awt.MenuBar
@OptIn(ExperimentalComposeUiApi::class)
fun main() = application {
    var action by remember { mutableStateOf("Last action: None") }
    Window(onCloseRequest = ::exitApplication) {
        MenuBar {
            Menu("File", mnemonic = 'F') {
                Item("Write", onClick = { action = "write" }, shortcut = KeyShortcut(Key.W, ctrl = true))
                Item("Learn", onClick = { action = "learn" }, shortcut = KeyShortcut(Key.L, ctrl = true))
            }
        }
        if(action == "write") {
//            Row(){
//                Column(
//                    modifier = Modifier.width(60.dp)
//                ) {
//                    KwiztoFileTree()
//                }
//
//                Text("Load File here")
//            }
            Row {
                KwiztoFileTree()
                Text("Load File Here")
            }

        }
        if(action == "learn") {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = action)
            }
        }
    }
}
