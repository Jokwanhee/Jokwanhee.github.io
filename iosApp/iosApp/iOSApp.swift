import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    @State private var friendId: String?

    var body: some Scene {
        WindowGroup {
            ContentView(friendId: friendId)
                .onOpenURL { url in
                    if let id = handleUrl(url) {
                        self.friendId = id
                    }
                }
        }
    }

    private func handleUrl(_ url: URL) -> String? {
        let path = url.path
        if path.count > 1 {
            return String(path.dropFirst())
        }
        return nil
    }
}
