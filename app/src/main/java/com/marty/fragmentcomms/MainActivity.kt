package com.marty.fragmentcomms

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jakewharton.rxbinding4.view.clicks
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_main.*

interface PlusOne {
    val plusObservable: BehaviorSubject<Unit>
    fun plusOne()
}

class MainActivity : AppCompatActivity(), PlusOne {


    private val disposables = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_layout_1, NumberFragment())
            add(R.id.fragment_layout_2, NumberFragment())
            commit()
        }
    }

    override fun onResume() {
        super.onResume()

        button_activity_plus.clicks()
            .subscribe {
                plusOne()
            }
            .also {
                disposables.add(it)
            }
    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        disposables.dispose()
    }

    override val plusObservable: BehaviorSubject<Unit> =  BehaviorSubject.create()
    override fun plusOne() {
        plusObservable.onNext(Unit)
    }
}
