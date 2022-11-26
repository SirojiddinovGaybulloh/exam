package comsirojiddinovgaybullo.Widget

import android.R.id
import android.R.layout
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService.RemoteViewsFactory
import comsirojiddinovgaybullo.core.di.module.Data.RecData.HomeData

class DataProvider(context: Context?, intent: Intent?) :
    RemoteViewsFactory {
    var myListView: MutableList<String> = ArrayList()
    var mContext: Context? = null

    init {
        mContext = context
    }

    override fun onCreate() {
        initData()
    }

    override fun onDataSetChanged() {
        initData()
    }

    override fun onDestroy() {}
    override fun getCount(): Int {
        return myListView.size
    }

    override fun getViewAt(position: Int): RemoteViews {
        val view = RemoteViews(mContext!!.packageName, layout.simple_list_item_1)
        view.setTextViewText(id.text1, myListView[position])
        return view
    }

    override fun getLoadingView(): RemoteViews? {
        return null
    }

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun hasStableIds(): Boolean {
        return true
    }

    private fun initData() {
        myListView.clear()
        for (i in 1..15) {
            myListView.add(homedata().random().dictionary)
        }
    }
    fun homedata(): ArrayList<HomeData> {
        return arrayListOf(
            HomeData("bed - yotoq"),
            HomeData("uncle - amaki"),
            HomeData("father - ota"),
            HomeData("mother - ona"),
            HomeData("brother - aka"),
            HomeData("sister - opa"),
            HomeData("nephew - jiyan"),
            HomeData("grandson - nevara"),
            HomeData("son - o'g'il"),
            HomeData("home - uy"),
            HomeData("water - suv"),
            HomeData("fire - olov"),
            HomeData("the rain - yomg'ir"),
            HomeData("telephone - telefon"),
            HomeData("alright - yaxshi"),
            HomeData("removed - olib tashlandi"),
            HomeData("rebel - isyonchi"),
            HomeData("ex - masalan"),
            HomeData("get - olish"),
            HomeData("general - umumiy"),
            HomeData("please - iltimos"),
            HomeData("for - uchun"),
            HomeData("hello - salom"),
            HomeData("honey - asal"),
            HomeData("kind - mehribon"),
            HomeData("sorry - kechirasiz"),
            HomeData("look - qarang"),
            HomeData("love - sevgi"),
            HomeData("what - nima"),
            HomeData("well - yaxshi"),
            HomeData("quite - juda"),
            HomeData("in - ichida"),
            HomeData("value - qiymat"),
            HomeData("view - ko'rinish"),
            HomeData("first - birinchi"),
            HomeData("journey - sayohat"),
            HomeData("jealous - rashkchi"),
            HomeData("thanks - rahmat"),
            HomeData("know - bilish"),
            HomeData("old - eski"),
            HomeData("olive - zaytun"),
            HomeData("meet - uchrashish"),
            HomeData("new - yanshi"),
            HomeData("next - keyingisi"),
            HomeData("urban - shaharlik"),
            HomeData("urge - undov"),
            HomeData("yummy - mazali"),
            HomeData("write - yozish"),
            HomeData("wrong - noto'g'ri"),
            HomeData("sick - kasal"),
            HomeData("various - har xil"),
            HomeData("vacation - dam olish"),
            HomeData("variety - xilma xillik"),
            HomeData("rude - qo'pol"),
            HomeData("run - yugur"),
            HomeData("rush - shoshilish"),
            HomeData("should - kerak"),
            HomeData("show - ko'rsatish"),
            HomeData("unfortunately - afsuski"),
            HomeData("under - ostida"),
            HomeData("until - qadar"),
            HomeData("understand - tushunish"),
            HomeData("glad - xursand"),
            HomeData("glass - sstakan"),
            HomeData("true - rost"),
            HomeData("trust - ishonch"),
            HomeData("trust me - menga ishoning"),
            HomeData("vocabulary - lug'at"),
            HomeData("volume - hajmi"),
            HomeData("voice - ovoz"),
            HomeData("volunteer - ko'ngilli"),
            HomeData("vowel - unli"),
            HomeData("vow - qasam"),
            HomeData("vowels - unlilar"),
            HomeData("later - keyinroq"),
            HomeData("last - oxirigi"),
            HomeData("late - kech"),
            HomeData("language - til"),
            HomeData("zeal - g'ayrat"),
            HomeData("zest - lazzat")

        )
    }

}