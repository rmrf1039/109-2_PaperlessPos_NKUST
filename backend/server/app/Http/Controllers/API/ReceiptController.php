<?php

namespace App\Http\Controllers\Api;

use App\Models\Receipts;
use Illuminate\Http\Request;
use App\Http\Controllers\Controller;
use Response;

class ReceiptController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $receipts = Receipts::get();
        return response(['receipts' => $receipts], 200);
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
     * @param  \App\Models\Receipts  $Receipts
     * @return \Illuminate\Http\Response
     */
    public function show(Receipts $Receipts)
    {
        return response($Receipts, 200);
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Models\Receipts  $Receipts
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Receipts $Receipts)
    {
        $Receipts->update($request->all());
        return response($Receipts, 200);
    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Models\Receipts  $Receipts
     * @return \Illuminate\Http\Response
     */
    public function destroy(Receipts $Receipts)
    {
        $Receipts->delete();
        return response(null, 204);
    }
}
