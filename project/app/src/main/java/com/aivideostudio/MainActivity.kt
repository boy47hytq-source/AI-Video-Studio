package com.aivideostudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AIVideoStudio() }
    }
}

@Composable
fun AIVideoStudio() {
    var story by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    MaterialTheme {
        Surface(Modifier.fillMaxSize()) {
            Column(
                Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text("AI Video Studio", style = MaterialTheme.typography.headlineMedium)
                Text("V1 • Bộ khung tạo phim bằng AI")

                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("🎬 Tạo phim từ ý tưởng", style = MaterialTheme.typography.titleMedium)
                        Text("Nhập ý tưởng, truyện hoặc kịch bản để chuẩn bị chuyển thành phim.")
                    }
                }

                Text("📖 Chuyển truyện thành kịch bản", style = MaterialTheme.typography.titleMedium)

                OutlinedTextField(
                    value = story,
                    onValueChange = { story = it },
                    modifier = Modifier.fillMaxWidth().height(220.dp),
                    label = { Text("Dán truyện của bạn") },
                    placeholder = { Text("Ví dụ: Một người đàn ông trở về quê sau 10 năm...") }
                )

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Button(
                        onClick = {
                            result = if (story.isBlank()) "Hãy dán một câu chuyện trước."
                            else "PHÂN TÍCH V1\n\nÝ tưởng: ${story.take(120)}\n\n• Thể loại: AI sẽ xác định\n• Nhân vật: AI sẽ phân tích\n• Bối cảnh: AI sẽ phân tích\n• Cấu trúc 3 hồi: AI sẽ tạo\n• Phân cảnh: AI sẽ chia scene\n• Prompt video: AI sẽ tạo theo scene"
                        },
                        Modifier.weight(1f)
                    ) { Text("Phân tích") }

                    OutlinedButton(
                        onClick = { story = ""; result = "" },
                        Modifier.weight(1f)
                    ) { Text("Xóa") }
                }

                if (result.isNotEmpty()) {
                    Card(Modifier.fillMaxWidth()) { Text(result, Modifier.padding(16.dp)) }
                }

                Card(Modifier.fillMaxWidth()) {
                    Column(Modifier.padding(16.dp)) {
                        Text("🚀 Lộ trình V1 → V2", style = MaterialTheme.typography.titleMedium)
                        Text("1. Truyện → kịch bản điện ảnh")
                        Text("2. Kịch bản → từng cảnh")
                        Text("3. Cảnh → prompt hình ảnh/video")
                        Text("4. Giọng nói + nhạc + hiệu ứng")
                        Text("5. Ghép thành video 5–10 phút")
                        Text("6. Kết nối nhiều AI để kiểm soát chi phí")
                    }
                }
            }
        }
    }
}
