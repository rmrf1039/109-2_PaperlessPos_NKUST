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
            'number' => Str::random(10),
            'seller_id' => '001',
            'detail' => Str::random(19),
            'uniform_num' => '76014406',
            'carrier' => Str::random(10),
            'amount' => mt_rand(1, 9999),
            'created_at' => Carbon::now()->format('Y-m-d H:i:s'),
            'updated_at' => Carbon::now()->format('Y-m-d H:i:s'),
        ]);
    }
}
