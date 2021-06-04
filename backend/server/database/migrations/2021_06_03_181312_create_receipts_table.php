<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateReceiptsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('receipts', function (Blueprint $table) {
            $table->string('number', 10)->primary();
            $table->string('seller_id', 15)->nullable(false);
            $table->json('detail')->nullable(false);
            $table->string('uniform_num', 8)->nullable();
            $table->string('carrier', 10)->nullable();
            $table->double('amount', 22, 0)->unsigned()->nullable(false);
            $table->timestamps();

            $table->foreign('carrier')->references('carrier')->on('users');
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('receipts');
    }
}
