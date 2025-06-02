package org.readora.readout.core.player.data.repository

import org.readora.readout.core.player.PlayerController
import org.readora.readout.core.player.domain.PlayerRepository

class PlayerRepositoryImpl(
    private val playerController: PlayerController
) : PlayerRepository {

    override fun play(audioUrl: String) {
        playerController.play(audioUrl)
    }

    override fun playAudioBase64(audioBase64: String) {
        playerController.playAudioBase64(audioBase64)
    }

    override fun playAll(audioUrls: List<String>) {
        playerController.playAll(audioUrls)
    }

    override fun forward() {
        playerController.forward()
    }

    override fun rewind() {
        playerController.rewind()
    }

    override fun pauseResume() {
        playerController.pauseResume()
    }
}