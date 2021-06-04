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
            $table->timestamps();
            $table->double('txn_amount', 22, 0)->unsigned();
            $table->string('txn_detail', 100);
            $table->string('sales_acc', 15);
            $table->string('taxID_num', 8)->nullable();
            $table->string('receipt_num', 10)->primary();
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
        Schema::dropIfExists('receipts');
    }
}
