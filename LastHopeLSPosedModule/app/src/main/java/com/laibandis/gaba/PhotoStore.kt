package com.laibandis.gaba

object PhotoStore {
    // Примитивное хранилище в памяти — для примера.
    private var photo: ByteArray? = null

    fun setPhoto(bytes: ByteArray) {
        photo = bytes
    }

    fun getPhotoBytes(): ByteArray? {
        return photo
    }

    fun clear() {
        photo = null
    }
}
