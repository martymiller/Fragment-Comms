package com.marty.fragmentcomms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.layout_number_fragment.*

class NumberFragment: Fragment() {

    private val disposables = CompositeDisposable()
    private var currentValue = 0
    private val subject = BehaviorSubject.createDefault(0)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.layout_number_fragment, null)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        button_fragment_plus.clicks().subscribe {
            subject.onNext(++currentValue)

        }.also {
            disposables.add(it)
        }

        subject.subscribe {
            fragment_number_text.text = it.toString()
        }
            .also {
                disposables.add(it)
            }

        (activity as? PlusOne)?.let {
            it.plusObservable.subscribe {
                button_fragment_plus.performClick()
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        disposables.dispose()
    }
}