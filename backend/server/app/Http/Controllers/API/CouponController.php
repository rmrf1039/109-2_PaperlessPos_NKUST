<?php

namespace App\Http\Controllers\Api;

use App\Models\Coupons;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Response;

class CouponController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $coupons = Coupons::get();
        return response(['coupons' => $coupons], 200);
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     *
     * @param  \App\Models\Coupons  $Coupons
     * @return \Illuminate\Http\Response
     */
    public function show(Coupons $coupons)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Coupons  $Coupons
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Coupons $Coupons)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Coupons  $Coupons
     * @return \Illuminate\Http\Response
     */
    public function destroy(Coupons $Coupons)
    {
        //
    }
}
