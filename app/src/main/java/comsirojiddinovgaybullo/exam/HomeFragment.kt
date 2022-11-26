package comsirojiddinovgaybullo.exam

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Context.NOTIFICATION_SERVICE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import comsirojiddinovgaybullo.adapters.details.DictionaryAdapter
import comsirojiddinovgaybullo.adapters.home.HomeAdapter
import comsirojiddinovgaybullo.core.di.module.Data.RecData.HomeData
import comsirojiddinovgaybullo.core.di.module.Data.UserData.NoteItem
import comsirojiddinovgaybullo.core.helper.ViewModelProviderFactory
import comsirojiddinovgaybullo.exam.databinding.HomeFragmentBinding
import comsirojiddinovgaybullo.service.MyForegroundService
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class HomeFragment : DaggerFragment() {

    private val binding by lazy {
        HomeFragmentBinding.inflate(layoutInflater)
    }

    private var adapterhome = HomeAdapter()
    private var adapterdictionary = DictionaryAdapter()
    private var sharedPreferences: SharedPreferences? = null

    @Inject
    lateinit var vmProviderFactory: ViewModelProviderFactory
    private val viewModel: HomeViewModel by viewModels { vmProviderFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.dictionary2.adapter = adapterdictionary
        binding.dictionary2.layoutManager = LinearLayoutManager(requireContext())
        binding.dictionary.adapter = adapterhome
        binding.dictionary.layoutManager =

            LinearLayoutManager(requireContext())

        viewModel.getAllData()
        binding.addBtn.setOnClickListener {
            var dictionareyDialog = DictionareyDialog(requireContext())
            dictionareyDialog.show()

            dictionareyDialog.setOnSaveButtonClick { english, uzbek ->

                viewModel.dictionaryList(NoteItem("$english - $uzbek"))
            }
        }

        sharedPreferences = requireContext().getSharedPreferences("night", Context.MODE_PRIVATE)
        var night: Boolean = sharedPreferences?.getBoolean("night_mode", true)!!
        if (night) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            binding.switch1.isChecked = true
        }

        binding.switch1.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                binding.switch1.isChecked = true
                var editor: SharedPreferences.Editor = sharedPreferences!!.edit()
                editor.putBoolean("night_mode", true)
                editor.commit()
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                binding.switch1.isChecked = false
                var editor: SharedPreferences.Editor = sharedPreferences!!.edit()
                editor.putBoolean("night_mode", false)
                editor.commit()
            }
        }

        viewModel.dictionaryListLiveData.observe(viewLifecycleOwner) {
            adapterdictionary.setData(it)
        }
        viewModel.homeList(homedata())


        viewModel.homeListLiveData.observe(viewLifecycleOwner) {
            adapterhome.data = it
        }

        viewModel.alldata.observe(viewLifecycleOwner){
            adapterdictionary.setData(it!!)
        }

        adapterdictionary.deleteBtn = {
            viewModel.getAllData()
            viewModel.delete(it)
        }
    }



    private val CHANNEL_ID="channel1"

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "R.string.channel_name"
            val descriptionText ="R.string.channel_description"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Register the channel with the system
            val manager =
                requireActivity().getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    private val notificationId=123
    private fun createNotification() {

        val builder = NotificationCompat.Builder(requireContext(), CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("textTitle")
            .setContentText("textContent")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)


        createNotificationChannel()

        with(NotificationManagerCompat.from(requireContext())) {
            // notificationId is a unique int for each notification that you must define
            notify(notificationId, builder.build())
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