package com.ducnguyen2102.werewolfmoderator.ui.gameplay

import android.media.MediaPlayer
import android.os.Bundle
import com.ducnguyen2102.werewolfmoderator.BR
import com.ducnguyen2102.werewolfmoderator.R
import com.ducnguyen2102.werewolfmoderator.base.BaseFragment
import com.ducnguyen2102.werewolfmoderator.binding.FragmentDataBindingComponent
import com.ducnguyen2102.werewolfmoderator.databinding.FragmentGamePlayBinding
import com.ducnguyen2102.werewolfmoderator.model.Character
import com.ducnguyen2102.werewolfmoderator.ui.MainSharedViewModel
import com.ducnguyen2102.werewolfmoderator.util.autoCleared
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class GamePlayFragment : MediaPlayer.OnPreparedListener, BaseFragment<FragmentGamePlayBinding, GamePlayViewModel>() {
    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer.start()
    }

    override val bindingVariable = BR.viewModel

    override val layoutId = R.layout.fragment_game_play

    override val viewModel: GamePlayViewModel by viewModel()

    private val sharedViewModel: MainSharedViewModel by sharedViewModel()

    private var bindingComponent = FragmentDataBindingComponent(this)

    private var gamePlayAdapter by autoCleared<GamePlayAdapter>()

    private lateinit var listCharacter: List<Character>

    private lateinit var listSentence: List<String>

    private var listCharacterSentenceId = listOf(
            R.array.idiot,
            R.array.cupid,
            R.array.two_sisters,
            R.array.three_brothers,
            R.array.wild_child,
            R.array.ancient,
            R.array.savior,
            R.array.wolf,
            R.array.vile_father_of_wolf,
            R.array.big_dad_wolf,
            R.array.witch,
            R.array.seer,
            R.array.fox,
            R.array.knight,
            R.array.hunter,
            R.array.flutist,
            R.array.villager)

    private var currentNight = 1

    private var currentCharacter = 0

    private var currentSence = 0

    private val mediaPlayer = MediaPlayer()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewDataBinding.run {
            listCharacter = sharedViewModel.listCharacter.value!!
            gamePlayAdapter = GamePlayAdapter(bindingComponent) {
            }
            listSentences.adapter = gamePlayAdapter
            listSentence = context!!.resources.getStringArray(listCharacterSentenceId[listCharacter[currentCharacter].type.type - 1]).toList()
            viewModel!!.currentCharacterImage.value = listCharacter[currentCharacter].imageId
            viewModel!!.currentCharacterName.value = listCharacter[currentCharacter].nameId
            val listItem = ItemSentenceViewModel.createListItem(listSentence)
            gamePlayAdapter.submitList(listItem)

            skipPrevious.setOnClickListener {
                skipPrevious()
            }
            rewind.setOnClickListener {
                rewind()
            }
            replay.setOnClickListener {
                startAudio()
            }
            forward.setOnClickListener {
                forward()
            }
            skipNext.setOnClickListener {
                skipNext()
            }
        }
        startAudio()
    }

    private fun startAudio() {
        val characterType = listCharacter[currentCharacter].type.type
        val position = currentSence + 1
        val afd = context!!.assets.openFd("voice/voice${characterType}_$position.mp3")
        mediaPlayer.reset()
        mediaPlayer.setDataSource(afd.fileDescriptor, afd.startOffset, afd.length)
        mediaPlayer.prepare()
        mediaPlayer.start()
    }

    private fun skipPrevious() {
        if (currentCharacter != 0) {
            currentSence = 0
            currentCharacter -= 1
            while (!listCharacter[currentCharacter].isCalledEveryNight && currentNight != 1) {
                if (currentCharacter != 0) currentCharacter -= 1
                else {
                    currentCharacter = listCharacter.lastIndex
                    currentNight -= 1
                }
            }
            listSentence = context!!.resources.getStringArray(listCharacterSentenceId[listCharacter[currentCharacter].type.type - 1]).toList()
            viewModel.currentCharacterImage.value = listCharacter[currentCharacter].imageId
            viewModel.currentCharacterName.value = listCharacter[currentCharacter].nameId
            viewModel.currentNight.value = currentNight
            val newList = ItemSentenceViewModel.createListItem(listSentence)
            gamePlayAdapter.submitList(newList)
        } else {
            if (currentNight != 1) {
                currentNight -= 1
                currentSence = 0
                currentCharacter = listCharacter.lastIndex
                while (!listCharacter[currentCharacter].isCalledEveryNight && currentNight != 1) {
                    if (currentCharacter != 0) currentCharacter -= 1
                    else {
                        currentCharacter = listCharacter.lastIndex
                        currentNight -= 1
                    }
                }
                listSentence = context!!.resources.getStringArray(listCharacterSentenceId[listCharacter[currentCharacter].type.type - 1]).toList()
                viewModel.currentNight.value = currentNight
                viewModel.currentCharacterImage.value = listCharacter[currentCharacter].imageId
                viewModel.currentCharacterName.value = listCharacter[currentCharacter].nameId
                val newList = ItemSentenceViewModel.createListItem(listSentence)
                gamePlayAdapter.submitList(newList)
            }
        }
        startAudio()
    }

    private fun rewind() {
        if (currentSence == 0) {
            if (currentCharacter != 0) {
                currentCharacter -= 1
                while (!listCharacter[currentCharacter].isCalledEveryNight && currentNight != 1) {
                    if (currentCharacter != 0) currentCharacter -= 1
                    else {
                        currentCharacter = listCharacter.lastIndex
                        currentNight -= 1
                    }
                }
                listSentence = context!!.resources.getStringArray(listCharacterSentenceId[listCharacter[currentCharacter].type.type - 1]).toList()
                viewModel.currentCharacterImage.value = listCharacter[currentCharacter].imageId
                viewModel.currentCharacterName.value = listCharacter[currentCharacter].nameId
                viewModel.currentNight.value = currentNight
                currentSence = listSentence.lastIndex
                val newList = ItemSentenceViewModel.createListItem(listSentence)
                gamePlayAdapter.submitList(newList)
            } else {
                if (currentNight != 1) {
                    currentNight -= 1
                    currentCharacter = listCharacter.lastIndex
                    while (!listCharacter[currentCharacter].isCalledEveryNight && currentNight != 1) {
                        if (currentCharacter != 0) currentCharacter -= 1
                        else {
                            currentCharacter = listCharacter.lastIndex
                            currentNight -= 1
                        }
                    }
                    listSentence = context!!.resources.getStringArray(listCharacterSentenceId[listCharacter[currentCharacter].type.type - 1]).toList()
                    viewModel.currentCharacterImage.value = listCharacter[currentCharacter].imageId
                    viewModel.currentCharacterName.value = listCharacter[currentCharacter].nameId
                    viewModel.currentNight.value = currentNight
                    currentSence = listSentence.lastIndex
                    val newList = ItemSentenceViewModel.createListItem(listSentence)
                    gamePlayAdapter.submitList(newList)
                }
            }
        } else currentSence -= 1
        startAudio()
    }

    private fun forward() {
        if (currentSence == listSentence.lastIndex) {
            if (currentCharacter != listCharacter.lastIndex) {
                currentCharacter += 1
                while (!listCharacter[currentCharacter].isCalledEveryNight && currentNight != 1) {
                    if (currentCharacter != listCharacter.lastIndex) currentCharacter += 1
                    else {
                        currentCharacter = 0
                        currentNight += 1
                    }
                }
                listSentence = context!!.resources.getStringArray(listCharacterSentenceId[listCharacter[currentCharacter].type.type - 1]).toList()
                viewModel.currentCharacterImage.value = listCharacter[currentCharacter].imageId
                viewModel.currentCharacterName.value = listCharacter[currentCharacter].nameId
                viewModel.currentNight.value = currentNight
                currentSence = 0
                val newList = ItemSentenceViewModel.createListItem(listSentence)
                gamePlayAdapter.submitList(newList)
            } else {
                currentNight += 1
                currentCharacter = 0
                while (!listCharacter[currentCharacter].isCalledEveryNight && currentNight != 1) {
                    if (currentCharacter != listCharacter.lastIndex) currentCharacter += 1
                    else {
                        currentCharacter = 0
                        currentNight += 1
                    }
                }
                currentSence = 0
                listSentence = context!!.resources.getStringArray(listCharacterSentenceId[listCharacter[currentCharacter].type.type - 1]).toList()
                viewModel.currentCharacterImage.value = listCharacter[currentCharacter].imageId
                viewModel.currentCharacterName.value = listCharacter[currentCharacter].nameId
                viewModel.currentNight.value = currentNight
                val newList = ItemSentenceViewModel.createListItem(listSentence)
                gamePlayAdapter.submitList(newList)

            }
        } else currentSence += 1
        startAudio()
    }

    private fun skipNext() {
        if (currentCharacter != listCharacter.lastIndex) {
            currentSence = 0
            currentCharacter += 1
            while (!listCharacter[currentCharacter].isCalledEveryNight && currentNight != 1) {
                if (currentCharacter != listCharacter.lastIndex) currentCharacter += 1
                else {
                    currentCharacter = 0
                    currentNight += 1
                }
            }
            listSentence = context!!.resources.getStringArray(listCharacterSentenceId[listCharacter[currentCharacter].type.type - 1]).toList()
            viewModel.currentCharacterImage.value = listCharacter[currentCharacter].imageId
            viewModel.currentCharacterName.value = listCharacter[currentCharacter].nameId
            viewModel.currentNight.value = currentNight
            val newList = ItemSentenceViewModel.createListItem(listSentence)
            gamePlayAdapter.submitList(newList)
        } else {
            currentNight += 1
            currentCharacter = 0
            while (!listCharacter[currentCharacter].isCalledEveryNight && currentNight != 1) {
                if (currentCharacter != listCharacter.lastIndex) currentCharacter += 1
                else {
                    currentCharacter = 0
                    currentNight += 1
                }
            }
            currentSence = 0
            listSentence = context!!.resources.getStringArray(listCharacterSentenceId[listCharacter[currentCharacter].type.type - 1]).toList()
            viewModel.currentNight.value = currentNight
            viewModel.currentCharacterImage.value = listCharacter[currentCharacter].imageId
            viewModel.currentCharacterName.value = listCharacter[currentCharacter].nameId
            val newList = ItemSentenceViewModel.createListItem(listSentence)
            gamePlayAdapter.submitList(newList)
        }
        startAudio()
    }
}