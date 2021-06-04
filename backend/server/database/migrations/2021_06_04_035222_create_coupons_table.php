<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateCouponsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('coupons', function (Blueprint $table) {
            $table->timestamps();
            $table->String('sales_acc',15)->nullable(false);
            $table->String('coupon_name',20)->nullable(false);
            $table->dateTime('exp_date')->nullable(false);
            $table->String('notice',10)->nullable();
            $table->String('coupon_barcode',20)->primary();
            $table->string('carrier_num', 10)->nullable();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('coupons');
    }
}
