package com.example.afinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var newsAdapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val layoutManager = LinearLayoutManager(this)
        newsRecycler.layoutManager = layoutManager
        newsAdapter = NewsAdapter(ArrayList())
        newsRecycler.adapter = newsAdapter

        getNewsData()

    }

    private fun getNewsData() {
        RetrofitClient.newsApi.getNews()
            .enqueue(object : Callback<NewsArr<List<News>>> {
                override fun onFailure(call: Call<NewsArr<List<News>>>, t: Throwable) {
                    Toast.makeText(this@MainActivity, "Failed to fetch!", Toast.LENGTH_LONG).show()
                }

                override fun onResponse(
                    call: Call<NewsArr<List<News>>>,
                    response: Response<NewsArr<List<News>>>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        newsAdapter.updateNews(response.body()!!.news)
                    }
                }

            })
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.sign_out, menu)
        return super.onCreateOptionsMenu(menu)
    }
    private val mAuth: FirebaseAuth? = null
    private lateinit var auth: FirebaseAuth
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        auth = FirebaseAuth.getInstance();

        if (item.itemId == R.id.logout) {

            auth.signOut()
            finish()

        }
        return super.onOptionsItemSelected(item)
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        auth.signOut()
//    }
}
