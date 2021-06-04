<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Str;
use Carbon\Carbon;

class CouponsSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        DB::table('coupons')->insert([
            'created_at' => Carbon::now()->format('Y-m-d H:i:s'),
            'updated_at' => Carbon::now()->format('Y-m-d H:i:s'),
            'sales_acc' => '001',
            'coupon_name' => 'CouponTEST_'.Str::random(5),
            'exp_date' => Carbon::now()->format('Y-m-d H:i:s'),
            'coupon_barcode' => Str::random(20),
            'carrier_num' => Str::random(10),
        ]);
    }
}
