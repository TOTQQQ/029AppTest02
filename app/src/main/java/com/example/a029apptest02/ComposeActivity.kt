package com.example.a029apptest02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// 数据类：一个任务
data class Task(
    val id: Int,
    val title: String,
    val isCompleted: Boolean = false
)

class ComposeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    TaskApp()
                }
            }
        }
    }
}

@Composable
fun TaskApp() {
    // 输入框的文本状态
    var inputText by remember { mutableStateOf("") }

    // 任务列表状态（可观察列表，增删改会触发 UI 更新）
    val tasks = remember {
        mutableStateListOf(
            Task(1, "学习 Column 和 Row", true),
            Task(2, "学习状态管理", false),
            Task(3, "完成 Compose 实验", false)
        )
    }
    // 下一个任务的 id
    var nextId by remember { mutableStateOf(4) }

    // 计算完成数（从 tasks 派生）
    val completedCount = tasks.count { it.isCompleted }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // 标题
        Text(
            text = "课程学习任务",
            color = Color(0xFFC41E3A),
            fontSize = 22.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 输入行：输入框 + 添加按钮
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            OutlinedTextField(
                value = inputText,
                onValueChange = { inputText = it },
                placeholder = { Text("请输入学习任务") },
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(
                onClick = {
                    if (inputText.isNotBlank()) {
                        tasks.add(Task(nextId, inputText, false))
                        nextId++
                        inputText = ""
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFC41E3A)
                )
            ) {
                Text("添加")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 进度显示
        Text(
            text = "已完成: $completedCount / ${tasks.size}",
            color = Color.Gray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        // 任务列表
        LazyColumn(
            modifier = Modifier.fillMaxWidth()
        ) {
            items(tasks, key = { it.id }) { task ->
                TaskItem(
                    task = task,
                    onToggle = {
                        val index = tasks.indexOfFirst { it.id == task.id }
                        if (index >= 0) {
                            tasks[index] = task.copy(isCompleted = !task.isCompleted)
                        }
                    },
                    onDelete = {
                        tasks.removeAll { it.id == task.id }
                    }
                )
            }
        }
    }
}

@Composable
fun TaskItem(
    task: Task,
    onToggle: () -> Unit,
    onDelete: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = { onToggle() },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFFC41E3A)
            )
        )

        Text(
            text = task.title,
            modifier = Modifier.weight(1f),
            color = if (task.isCompleted) Color.Gray else Color.Black,
            textDecoration = if (task.isCompleted)
                TextDecoration.LineThrough else null
        )

        TextButton(onClick = { onDelete() }) {
            Text("删除", color = Color(0xFFC41E3A))
        }
    }
}

@Preview(showBackground = true, name = "任务列表预览")
@Composable
fun TaskAppPreview() {
    MaterialTheme {
        TaskApp()
    }
}
