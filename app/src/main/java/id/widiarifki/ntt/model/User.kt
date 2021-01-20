package id.widiarifki.ntt.model

class User {

    var id: Int = 0
    var username: String? = null
    var password: String? = null

    companion object {
        const val DEFAULT_USERNAME = "test"
        const val DEFAULT_PASSWORD = "1234"
    }

}