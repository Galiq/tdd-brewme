describe('plugin test - value should be valid', function() {
    beforeEach(function(){
        setFixtures('<input id="input" value="test@test.pl"/><form id="form"><input id="input" value="test@test.pl"/></form>');
    });    
    it("initial input should be not validated", function(){
        expect($('#form').children('p')).not.toBe();
    });
    it("initial input should be valid", function(){
        $('#form').waliduj();
        expect($('#form').children('p')).not.toBe();
    });
});

describe('plugin test - value should be invalid', function() {
    beforeEach(function(){
        setFixtures('<form id="form"><input id="input" value="Ivalid_Email"/></form>');
    });    
    it("initial input should be not validated", function(){
        expect($('#form').children('p')).not.toBe();
    });
    it("initial input should be invalid", function(){
        $('#form').waliduj();
        expect($('#form').children('p').text() == 'Error!').toBe(true);
    });
});

describe('plugin test - error message should be removed', function() {
    beforeEach(function(){
        setFixtures('<form id="form"><input id="input" value="Ivalid_Email"/><input id="input2" value="test@test.pl"/></form>');
    });    
    it("initial input should be not validated", function(){
        expect($('#form').children('p')).not.toBe();
    });
    it("initial input should be invalid", function(){
        $('#form').waliduj();
        expect($('#form').children('p').text() == 'Error!').toBe(true);
    });
  
    it("initial input should be not validated", function(){
        $('#form').children('input').val('valid@mail.com')
        $('#form').waliduj();
        expect($('#form').children('p')).not.toBe();
    });
});