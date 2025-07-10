import UIKit
import SwiftUI
import ComposeApp

struct ComposeView: UIViewControllerRepresentable {
    var friendId: String?

    func makeUIViewController(context: Context) -> UIViewController {
        return MainViewControllerKt.MainViewController(friendId: friendId)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {
        // 필요한 경우 여기서 ViewController 업데이트
    }
}

struct ContentView: View {
    var friendId: String?

    var body: some View {
        ComposeView(friendId: friendId)
            .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}



