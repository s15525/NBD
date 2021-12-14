db.test.updateMany(
{
    "job":"Editor"
},{
    $unset:{
        "email":""
    }
})