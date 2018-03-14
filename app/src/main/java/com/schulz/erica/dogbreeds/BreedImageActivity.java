package com.schulz.erica.dogbreeds;

//public abstract class BreedImageActivity extends AppCompatActivity implements BreedImageApiTask.BreedImageApiTaskCallBack, BreedApiTask.BreedApiTaskCallBack {
//
//
//    BreedImageApiTask breedImageApiTask;
//    BreedApiTask breedApiTask;
//    ListView breedImageListView;
//    BreedImageListAdapter breedImageListAdapter;
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        this.setContentView(R.layout.activity_image);
//
//
//        try {
//            this.startBreedImageAsyncRequest();
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        final Intent mainIntent2 = new Intent(BreedImageActivity.this, MainActivity.class);
//        Button back = findViewById(R.id.back_button_2);
//        back.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//
//                startActivity(mainIntent2);
//            }
//        });
//    }
//
//
//
//    public void startBreedImageAsyncRequest() throws JSONException {
//
//        this.breedImageApiTask = new BreedImageApiTask(BreedImageActivity.this);
//        this.breedImageApiTask.execute();
//    }
//
////    @Override
////    public void breedImageApiTaskCompleted(List<BreedImage> breedImageList) {
//
//
//
//
//
////        for (Breed breed:breedList) {
////            String breedName = breed.getBreedName();
////            Log.d("log this", breedName);
//
//
//
//
////            try {
////
////                BreedImageApiTask breedImageApiTask = new BreedImageApiTask(this);
////                breedImageApiTask.setBreedName(breedName);
////                breedImageApiTask.execute();
////            } catch (JSONException e) {
////                e.printStackTrace();
////            }
////
////        }
//
////
////        breedImageListView = findViewById(R.id.image_list);
////        breedImageListAdapter = new BreedImageListAdapter(this, R.layout.text_view_2, breedImageList);
////        breedImageListView.setAdapter(breedImageListAdapter);
//
//        Log.d("log this", "");
//
//    }
//
//}
