package com.kwizto.common

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.bonsai.core.Bonsai
import cafe.adriel.bonsai.filesystem.FileSystemBonsaiStyle
import cafe.adriel.bonsai.filesystem.FileSystemTree
import java.io.File

@Composable
fun KwiztoFileTree() {
    val tree = FileSystemTree(
        // Also works with java.nio.file.Path and okio.Path
        rootPath = File("/home/mrtechmaker/works/kwiztodesktop/cards"),
        // To show or not the root directory in the tree
        selfInclude = true
    )

    Bonsai(
        tree = tree,
        onClick = { node ->
            tree.clearSelection()
            tree.expandUntil(2)
        },
        // Custom style
        modifier= Modifier.width(250.dp).border(border= BorderStroke(2.dp, Color.Black)),
        style = FileSystemBonsaiStyle()
    )
}
