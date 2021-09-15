package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


//ARCHITECTURE PATTERN
//we have different patterns like MVC, MVP, MVVM etc

//jb hm koi application banatay hein to us m 2 factors hote hien SCALABILITY & MAINTAINABILITY
//SCALABILITY: hm n software m koi feature add krna hoga
//MAINTAINABILITY: agr hm n software m kuch changes krni hon to, jese k hamari maintenance
//Architecture pattern mainly focus on 2 things: Separation of concerns & Unit testing
//SEPARATION OF CONCERNS: yani hm apni application ko different components m torr dete hein, hr component ki apni aik responsibility hoti h
//SEPARATION OF CONCERNS: yani jahan p b m n apna feature add krna h sirf wahen p impact hoga bqi sb apni jaga p hongay
//UNIT TESTING : iska mtlb y h k hm n koi changes ki hein to hm usko test kr payen k us k exisitng features to break nh hogaye,
//jtne zyada hamare features independent hoga utna he hm uni testing sahe s kr payengay
//is lye jb hm koi application banatay hein to hm ksi ARCHITECTURE PATTERN ko follow krein ta k wo code scalable ho or maintainable ho
//based on application hm decide krte hein k hm n knsa architecture use krna h

//MVC (MODEL VIEW CONTROLLER) :simple architecture pattern hai, android ka default architecture h
//is m hm inko 3 layers m torr dete hein 1. View 2. Controller 3. Model
//1. VIEW: layout files (xml) is m hamare button ya events
//2. CONTROLLER: Activity/ Fragment (event handling ka kam controller m)
//3. MODEL: (Data classes etc )Jtna b hamara database s ya  busines logic s related kam hota hai wo model m, model layer dependent hoti h uska view or controller s koi taluq nh h
// view directly model s interact nh krta h. view controller ko information deta h r phr Controller decide krta h k kya krna h
//VIEW Layer CONTROLLER layer s tightly coupled hai
// yani agr m uni testing CONTROLLER ki krunga to is m jo component use ho rhe hien wo VIEW s a rhe hien to us k according TEST CASES lkhe jayengay



// isse CONTROLLER OR VIEW k tightly coupled ki waja s hm aik or pattern use krte hien jisse MVP kehte hein
/*MVP (MODEL VIEW PRESENTER)*/
// 1. VIEW 2. PRESENTER 3. MODEL
// is n y kiya jo hamari CONTROLLER wala part tha is n usay PRESENTER kr diya, or jo actvity or fragment tha wo VIEW m include kr diya
//or PRESENTER hamari simple aik class hogi , jis m hm simple presentation logic laga payengay
// agr PRESENTER  ko VIEW s baat krni h to us k lye hamare pas INTERFACES hote hien .
// is m dono independent hote hein .
// ab VIEW , PRESENTER or MODEL independent hein hm easily test cases bana skte hien
// mostly android application m y MVP use hota h

// class myPresenter (myView: View) : Presenter
//yani k mypresenter ko agr view s baat krne h to myview k through krega. myview: View hamara yahan interface hai
//yani agr VIEW LAYER m kuch change hota hai to mjhy PRESENTER LAYER ko btanay ki zarurt nh hai, m us interface ko inherit kr lunga or apna code change kr lunga VIEW LYAER mein


/*MVVVM (MODEL VIEW VIEW MODEL)*/
// 1. VIEW 2. VIEW MODEL 3. MODEL
// is m jo hamara presenter hai wo hamara VIEW MODEL ban jata hai, 3no layer clear separation hein
//MVP mein hm interface ko use kr rhe the interaction k lye.
//lekn MVVM m MODELVIEW directly interact nh krengay VIEW k sth, beech m hm OBSERVABLES bana lengay
//VIEWMODEL wali layer hamaray VIEW k lye data rkhege or
// or jo VIEW data EXPOSE krege wo OBSERABLE k through krege
//to jb b hamare VIEWS ko data chaye hoga to wo hamare is OBSERVABLE ko observe krengay to us k according hamaray VIEWS change hote rhengay.
//ho hamari VIEWMODEL layer h wo independent hogai hamari VIEW layer s
//jaise he data change hoga MODELVIEW mein VIEW ko pta chal jayega OBSERVABLES k through to us k according wo apni UI update kr dega
// to jtne m events hamaray VIEW mein hongay wo VIEWMODEL m phnchengay, VIEW MODEL unko process krega, usko MODEL(DATABASE)  mein save krna hoga ya NETWORK CALL marni hogi to NETWORK CALL marega.
//us k according hamara data update hoga yani hamara OBSERABLE update hoga to yun hamara VIEWS update hojayengay
// is trhan y pori cycle chal jayege
//ANDROID ka jo hamara architecture he us m hm n  y MODEL ko b break kr diya h uski jaga REPOSITORY use kr diya h
// or jo hamari REPOSITORY hogi wo DATABASE OR API s INTERACT krege
//agr REPOSITORY ko data chaye hoga to wo API or DATABASE s interact krege
//1. VIEW 2. VIEW MODEL 3. REPOSITORY 3.1 API(web services, retrofit) 3.2 DATABASE (sqlite)
//in sb k lye hm UNI TEST lkh skte hien
//large apps k lye acha architecture hai



//ANDROID ARCHITECTURE COMPONENTS
// Android m hamaray pas different components hote hein jis m activity , fragments , services, broadcast receiver hote hien, in components ko mila k hamari app bnti h
//y jtne b components hein y hm manage nh krte Android manage krta hai  hm bs code krte hien r android ko kehte hien y kr dena wo krdena to android hamare lye wo krta h
// activities hon ya fragment hon y hm to manage krte nh to y android h k wo kb show kre kb hide kre kb destroy kr de kb low memeory ki situation ho
//agr ap apni app ka data in components k andr store krengay to us k reliabilty nh h, us pr hamara control nh h
//hm chahte hein k hm apna data khd manage ya control krein
// is m r b bht se problems a rhe the jese k activity m data store kr rhe the , bs actvity m kam s kam data rkhne chahte hien jo uska kam h bs wo wohe kre
//aik or problem jo face kr rhe screen rotation ka jese he ap screen rotate krte ho to apka data loss ho rha tha q k ON CREATE ka method activitty m dubara recreate ho rha tha
// agr hm data alag kr den to jaise activity apna kam kr rhe the wo kam krti rahe or hamara data bacha rahega
//is s pehele m koi architecture follow hota tha jis m sb component lnk the (MVC, MVP, MMVM)
//MVVM k anay s architecture component easy hogya h
// in pattern(mvc,mvp,mvvm) in s hm chahte hein separation of concerns mtlb jo cheez jis k lye banai h wo wohe kam kre
//hm chahte hein data driven application hon (iska mtlb y h k agr data change hoga to us k base p bqi b change ho jaise UI)
// agr UI  change hogi to apka interaction change hoga jb interaction change hoga to data b change hoga
// in s y hoga mere app maintanble hojayege r us m feature add krna asan hojayega


//JET PACK
//JET PACK aik set of libraries hein jis ko hm individually use kr skte hien
//is s pehel support libraries hote thein jo hamare lye sara kam manage krti the us m hamare lye fragment, animation or is k ilawa ka code tha
//jo k poora aik bundle tha, ab un budle ko split kr diya different libraries mein
//ab sari libraries alg alg manage hoti hein, ab sb libraries ka apna dedicated kam h wo bs ab wohe perform krti hein
// or is m kuch additional libraries hein jo hm use krengay apnay architecture ko manage krne k lye
//hamari jo libraries ya compnents hein unhen hm alag alg test b kr sakenngay
// is b hm SQL QUERIES jo the unko avoid krengay navigation  k lye hm intent use krte the wo b ab navigation components m move ho chuka hai
// ab hm high quality apps bana skte hien in libraries ko use kr k
// hm jetpack ki website m ja k us library ko apne app m use kr sakengay



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}