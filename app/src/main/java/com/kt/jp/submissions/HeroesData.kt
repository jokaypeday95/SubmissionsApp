package com.kt.jp.submissions

object HeroesData {
    private val heroName = arrayOf(
        "Universitas Indonesia",
        "Universitas Gadjah Mada",
        "Universitas Brawijaya",
        "Universitas Teknologi Bandung",
        "Universitas Airlangga",
        "Universitas Bina Nusantara",
        "Universitas Padjadjaran",
        "Universitas Sebelas Maret",
        "Universitas Diponegoro",
        "Institut Pertanian Bogor",
        "Universitas Telkom",
        "Institut Teknologi Sepuluh Nopember",
        "Universitas Pendidikan Indonesia",
        "Univrsitas Negeri Semarang",
        "Universitas Teknokrat Indonesia"
    )

    private val heroTopUniv = arrayOf(
        "Top 1 Universities in Indonesia",
        "Top 2 Universities in Indonesia",
        "Top 3 Universities in Indonesia",
        "Top 4 Universities in Indonesia",
        "Top 5 Universities in Indonesia",
        "Top 6 Universities in Indonesia",
        "Top 7 Universities in Indonesia",
        "Top 8 Universities in Indonesia",
        "Top 9 Universities in Indonesia",
        "Top 10 Universities in Indonesia",
        "Top 11 Universities in Indonesia",
        "Top 12 Universities in Indonesia",
        "Top 13 Universities in Indonesia",
        "Top 14 Universities in Indonesia",
        "Top 15 Universities in Indonesia"
    )

    private val heroStatusPT = arrayOf(
        "Negeri",
        "Negeri",
        "Negeri",
        "Negeri",
        "Negeri",
        "Swasta",
        "Negeri",
        "Negeri",
        "Negeri",
        "Negeri",
        "Swasta",
        "Negeri",
        "Negeri",
        "Negeri",
        "Swasta"
    )

    private val heroDetails = arrayOf(
        "Universitas Indonesia (Universitas Indonesia) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di kawasan perkotaan metropolis Depok (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Barat.",
        "Universitas Gadjah Mada (Universitas Gadjah Mada) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di pinggiran kota metropolis Sleman (rentang populasi 1.000.000-5.000.000 jiwa), Yogyakarta SR.",
        "Universitas Brawijaya (Universitas Brawijaya) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di kawasan perkotaan kota besar Malang (rentang populasi 500.000-1.000.000 jiwa), Jawa Timur.",
        "Institut Teknologi Bandung (Institut Teknologi Bandung) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di kawasan perkotaan kota metropolitan Bandung (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Barat.",
        "Universitas Airlangga (Universitas Airlangga) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di kawasan perkotaan metropolis Surabaya (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Timur.",
        "Universitas Bina Nusantara (Universitas Bina Nusantara) adalah lembaga pendidikan tinggi swasta nirlaba yang terletak di kawasan perkotaan kota metropolitan besar Jakarta (rentang populasi lebih dari 5.000.000 jiwa), Jakarta SCR.",
        "Universitas Padjadjaran (Universitas Padjadjaran) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di kota metropolitan Sumedang (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Barat.",
        "Universitas Sebelas Maret (Universitas Sebelas Maret) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di kawasan pinggiran kota metropolitan Surakarta (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Tengah.",
        "Universitas Diponegoro (Universitas Diponegoro) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di pedesaan kota metropolitan Semarang (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Tengah.",
        "Institut Pertanian Bogor (IPB University) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di kawasan perkotaan metropolis Bogor (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Barat.",
        "Universitas Telkom (Telkom University) adalah lembaga pendidikan tinggi swasta nirlaba yang terletak di kawasan pinggiran kota metropolitan Bandung (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Barat.",
        "Institut Teknologi Sepuluh Nopember (Institut Teknologi Sepuluh Nopember) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di kawasan perkotaan metropolis Surabaya (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Timur.",
        "Universitas Pendidikan Indonesia (Universitas Pendidikan Indonesia) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di kawasan perkotaan metropolis Bandung (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Barat.",
        "Universitas Negeri Semarang (Universitas Negeri Semarang) adalah lembaga pendidikan tinggi negeri nirlaba yang terletak di daerah pinggiran kota metropolitan Semarang (rentang populasi 1.000.000-5.000.000 jiwa), Jawa Tengah.",
        "Universitas Teknokrat Indonesia (Indonesia Teknokrat University) adalah sebuah institusi pendidikan tinggi swasta yang terletak di daerah pinggiran kota metropolitan Bandar Lampung (rentang populasi 1.000.000-5.000.000 jiwa), Lampung."
    )

    private val heroImages = intArrayOf(
        R.drawable.ui,
        R.drawable.ugm,
        R.drawable.ub,
        R.drawable.itb,
        R.drawable.ua,
        R.drawable.ubn,
        R.drawable.up,
        R.drawable.usm,
        R.drawable.undip,
        R.drawable.ipb,
        R.drawable.telu,
        R.drawable.itsn,
        R.drawable.upi,
        R.drawable.uns,
        R.drawable.uti
    )

    val listData: ArrayList<Hero>
    get() {
        val list = arrayListOf<Hero>()
        for (position in heroName.indices){
            val hero = Hero()
            hero.name = heroName[position]
            hero.peringkatPT = heroTopUniv [position]
            hero.statusPT = heroStatusPT[position]
            hero.detail = heroDetails[position]
            hero.photo = heroImages[position]
            list.add(hero)
        }
        return list
    }
}