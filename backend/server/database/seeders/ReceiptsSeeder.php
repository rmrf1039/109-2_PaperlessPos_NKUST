<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use Carbon\Carbon;

class ReceiptsSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('receipts')->insert([
            'created_at' => Carbon::now()->format('Y-m-d H:i:s'),
            'updated_at' => Carbon::now()->format('Y-m-d H:i:s'),
            'txn_amount' => mt_rand(1, 9999),
            'txn_detail' => Str::random(19),
            'sales_acc' => '001',
            'taxID_num' => '76014406',
            'receipt_num' => Str::random(10),
            'carrier_num' => Str::random(10),
        ]);
    }
}
