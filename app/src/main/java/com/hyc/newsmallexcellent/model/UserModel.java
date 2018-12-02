package com.hyc.newsmallexcellent.model;

import com.hyc.newsmallexcellent.base.interfaces.ILoading;
import com.hyc.newsmallexcellent.base.rx.BaseErrorConsumer;
import com.hyc.newsmallexcellent.base.rx.BaseRequestConsumer;
import com.hyc.newsmallexcellent.helper.RequestHelper;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserModel {

  public Disposable verificationUserPhone(String account, BaseRequestConsumer consumer,
      ILoading iLoading) {
    return RequestHelper.getRequestApi().sendVerificationCode(account)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(consumer, new BaseErrorConsumer(iLoading));
  }

  public Disposable register(String account, String password, String code,
      BaseRequestConsumer consumer, ILoading iLoading) {
    return RequestHelper.getRequestApi().register(account, password, code)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(consumer, new BaseErrorConsumer(iLoading));
  }

  public Disposable login(String account,String password,BaseRequestConsumer consumer,ILoading iLoading){
    return RequestHelper.getRequestApi().login(account,password)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(consumer, new BaseErrorConsumer(iLoading));
  }
}
