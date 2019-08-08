package com.ducnguyen2102.werewolfmoderator.ui.gameplay

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Toast
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

class GamePlayFragment : BaseFragment<FragmentGamePlayBinding, GamePlayViewModel>() {

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

    private var currentNight = 0

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
            listSentence = context!!.resources.getStringArray(listCharacterSentenceId[currentCharacter]).toList()
            val listItem = ItemSentenceViewModel.createListItem(listSentence)
            gamePlayAdapter.submitList(listItem)

            skipPrevious.setOnClickListener {
                if (currentCharacter != 0) {
                    currentSence = 0
                    currentCharacter -= 1
                    listSentence = context!!.resources.getStringArray(listCharacterSentenceId[currentCharacter]).toList()
                    currentSence = listSentence.lastIndex
                    val newList = ItemSentenceViewModel.createListItem(listSentence)
                    gamePlayAdapter.submitList(newList)
                }
                Toast.makeText(context!!, "$currentSence $currentCharacter", Toast.LENGTH_SHORT).show()
            }
            rewind.setOnClickListener {
                if (currentSence == 0) {
                    if (currentCharacter != 0) {
                        currentCharacter -= 1
                        listSentence = context!!.resources.getStringArray(listCharacterSentenceId[currentCharacter]).toList()
                        currentSence = listSentence.lastIndex
                        val newList = ItemSentenceViewModel.createListItem(listSentence)
                        gamePlayAdapter.submitList(newList)
                    }
                } else currentSence -= 1
                Toast.makeText(context!!, "$currentSence $currentCharacter", Toast.LENGTH_SHORT).show()
            }
            replay.setOnClickListener {
                Toast.makeText(context!!, "$currentSence $currentCharacter", Toast.LENGTH_SHORT).show()
            }
            forward.setOnClickListener {
                if (currentSence == listSentence.lastIndex) {
                    if (currentCharacter != listCharacter.lastIndex) {
                        currentCharacter += 1
                        listSentence = context!!.resources.getStringArray(listCharacterSentenceId[currentCharacter]).toList()
                        currentSence = 0
                        val newList = ItemSentenceViewModel.createListItem(listSentence)
                        gamePlayAdapter.submitList(newList)
                    }
                } else currentSence += 1
                Toast.makeText(context!!, "$currentSence $currentCharacter", Toast.LENGTH_SHORT).show()
            }
            skipNext.setOnClickListener {
                if (currentCharacter != listCharacter.lastIndex) {
                    currentSence = 0
                    currentCharacter += 1
                    listSentence = context!!.resources.getStringArray(listCharacterSentenceId[currentCharacter]).toList()
                    currentSence = listSentence.lastIndex
                    val newList = ItemSentenceViewModel.createListItem(listSentence)
                    gamePlayAdapter.submitList(newList)
                }
                Toast.makeText(context!!, "$currentSence $currentCharacter", Toast.LENGTH_SHORT).show()
            }
        }
        subscribeUI()
    }

    private fun subscribeUI() {
    }

    fun getAudioFile(characterType:Int,position:Int){

    }
}