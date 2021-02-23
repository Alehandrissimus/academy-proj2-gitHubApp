package com.example.academy_proj2_githubapp.reactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.academy_proj2_githubapp.R
import com.example.academy_proj2_githubapp.databinding.ReactionPickerDialogBinding
import com.example.academy_proj2_githubapp.reactions.models.ReactionType

class ReactionPickerDialog : DialogFragment() {

    companion object {
        fun newInstance(
            chosenReactions: List<ReactionType>,
            onReactionChosen: (ReactionType) -> Unit
        ): ReactionPickerDialog {
            return ReactionPickerDialog().apply {
                callback = onReactionChosen
                highlightedReactions = chosenReactions
            }
        }

        const val REACTION_PICKER_TAG = "REACTION_PICKER_TAG"
    }

    private var _binding: ReactionPickerDialogBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val reactionViews: HashMap<View, ReactionType> by lazy {
        hashMapOf(
            binding.ivPlusOne to ReactionType.PLUS_ONE,
            binding.ivMinusOne to ReactionType.MINUS_ONE,
            binding.ivEyes to ReactionType.EYES,
            binding.ivConfused to ReactionType.PLUS_ONE,
            binding.ivHeart to ReactionType.PLUS_ONE,
            binding.ivHooray to ReactionType.PLUS_ONE,
            binding.ivRocket to ReactionType.PLUS_ONE,
            binding.ivLaugh to ReactionType.PLUS_ONE,
        )
    }

    lateinit var callback: (ReactionType) -> Unit
    lateinit var highlightedReactions: List<ReactionType>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ReactionPickerDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reactionViews.keys.forEach { reactionView ->
            if (reactionViews[reactionView] in highlightedReactions) {
                reactionView.background =
                    ContextCompat.getDrawable(requireContext(), R.color.purple_200)
            }
            reactionView.setOnClickListener {
                callback(reactionViews[it] ?: ReactionType.UNDEFINED)
                dialog?.dismiss()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}