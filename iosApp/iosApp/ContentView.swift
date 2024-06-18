import shared
import SwiftUI

let greeting = Greeting()
let appManager = AppManager()

struct ContentView: View {
    var body: some View {
        Text("hey").onAppear {
            Task {
                for await result in appManager.testResultFlow {
                    print("totoResultSkie flow result=\(result)")
                }
            }
            Task {
                do {
                    try await appManager.testCall()
                } catch is NetworkException {
                    print("ça ne marche pas comme ça, il faut regarder l'exemple en dessous")
                } catch let error as NSError {
                    print("is network exception = \(error.kotlinException is NetworkException)")
                }
            }
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
